package com.tasly.commons.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by dulei on 9/28/17.
 */
@Slf4j
public class Beans {

  /**
   * <pre>
   *     List<UserBean> userBeans = userDao.queryUsers();
   *     List<UserDTO> userDTOs = BeanUtil.batchTransform(UserDTO.class, userBeans);
   * </pre>
   */
  public static <T> List<T> batchTransform(final Class<T> clazz, List<? extends Object> srcList) {
    if (CollectionUtils.isEmpty(srcList)) {
      return Collections.emptyList();
    }

    List<T> result = new ArrayList<>(srcList.size());
    for (Object srcObject : srcList) {
      result.add(transfrom(clazz, srcObject));
    }
    return result;
  }

  /**
   * 封装{@link org.springframework.beans.BeanUtils#copyProperties}，惯用与直接将转换结果返回
   *
   * <pre>
   *      UserBean userBean = new UserBean("username");
   *      return BeanUtil.transform(UserDTO.class, userBean);
   * </pre>
   */
  public static <T> T transfrom(Class<T> clazz, Object src) {
    if (src == null) {
      return null;
    }
    T instance = null;
    try {
      instance = clazz.newInstance();
    } catch (Exception e) {

      log.warn("转化bean失败: " + e.getMessage(),e);

      throw new IllegalArgumentException(e);
    }
    org.springframework.beans.BeanUtils.copyProperties(src, instance, getNullPropertyNames(src));
    return instance;
  }

  private static String[] getNullPropertyNames(Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<String>();
    for (PropertyDescriptor pd : pds) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null) emptyNames.add(pd.getName());
    }
    String[] result = new String[emptyNames.size()];

    return emptyNames.toArray(result);
  }


  /**
   * 用于将一个列表转换为列表中的对象的某个属性映射到列表中的对象
   *
   * <pre>
   *      ArrayList<User> integers = Lists.newArrayList(User.of());
   *       Map<String, User> integerIntegerMap = mapByKey(User::getName, integers);
   * </pre>
   *
   * @param function 属性值function
   * @param list 指定集合
   */

  public static <K, V> Map<K, V> mapByKey(Function<V,K> function, List<V> list) {
    Map<K, V> map = new HashMap<K, V>();
    if (CollectionUtils.isEmpty(list)) {
      return map;
    }
    return list.stream().collect(Collectors.toMap(function,Function.identity()));
  }

  /**
   * 根据列表里面的属性聚合
   *
   * <pre>
   *       List<ShopDTO> shopList = shopService.queryShops();
   *       Map<Integer, List<ShopDTO>> city2Shops = BeanUtil.mapListByKey(ShopDTO::getId, shopList);
   * </pre>
   */
  public static <K, V> Map<K, List<V>> mapListByKey(Function<V,K> function, List<V> list) {
    Map<K, List<V>> map = new HashMap<K, List<V>>();
    if (CollectionUtils.isEmpty(list)) {// 防止外面传入空list
      return map;
    }
    return list.stream().collect(Collectors.groupingBy(function));
  }

  /**
   * 用于将一个对象的列表转换为列表中对象的属性集合
   *
   * <pre>
   *     List<UserDTO> userList = userService.queryUsers();
   *     Set<Integer> userIds = BeanUtil.propertySet(UserDTO::getId, userList);
   * </pre>
   */
  public static <K,V> Set<K> propertySet(Function<V,K> function, List<V> list) {
    Set<K> set = new HashSet<K>();
    if (CollectionUtils.isEmpty(list)) {// 防止外面传入空list
      return set;
    }

    return list.stream().map(function).collect(Collectors.toSet());
  }

  /**
   * 用于将一个对象的列表转换为列表中对象的属性集合(不去重)
   *
   * <pre>
   *     List<UserDTO> userList = userService.queryUsers();
   *     List<Integer> userIds = BeanUtil.propertyList(UserDTO::getId, userList);
   * </pre>
   */
  public static <K,V> List<K> propertyList(Function<V,K> function, List<V> list) {
    if (CollectionUtils.isEmpty(list)) {// 防止外面传入空list
      return new ArrayList<K>();
    }

    return list.stream().map(function).collect(Collectors.toList());
  }

  /**
   * 用于将一个对象的列表转换为列表中对象的属性集合(去重)
   *
   * <pre>
   *     List<UserDTO> userList = userService.queryUsers();
   *     List<Integer> userIds = BeanUtil.propertyListDistinct(UserDTO::getId, userList);
   * </pre>
   */
  public static <K,V> List<K> propertyListDistinct(Function<V,K> function, List<V> list) {
    if (CollectionUtils.isEmpty(list)) {// 防止外面传入空list
      return new ArrayList<K>();
    }

    return list.stream().map(function).distinct().collect(Collectors.toList());
  }



  private static Field deepFindField(Class<? extends Object> clazz, String key) {
    Field field = null;
    while (!clazz.getName().equals(Object.class.getName())) {
      try {
        field = clazz.getDeclaredField(key);
        if (field != null) {
          break;
        }
      } catch (Exception e) {
        clazz = clazz.getSuperclass();
      }
    }
    return field;
  }

  /**
   * 获取某个对象的某个属性
   */
  public static Object getProperty(Object obj, String fieldName) {
    try {
      Field field = deepFindField(obj.getClass(), fieldName);
      if (field != null) {
        field.setAccessible(true);
        return field.get(obj);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
    return null;
  }

  /**
   * 设置某个对象的某个属性
   */
  public static void setProperty(Object obj, String fieldName, Object value) {
    try {
      Field field = deepFindField(obj.getClass(), fieldName);
      if (field != null) {
        field.setAccessible(true);
        field.set(obj, value);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * 
   * @param source
   * @param target
   */
  public static void copyProperties(Object source, Object target, String... ignoreProperties) {
    org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
  }

  /**
   * The copy will ignore <em>BaseEntity</em> field
   *
   * @param source
   * @param target
   */
  public static void copyEntityProperties(Object source, Object target) {
    org.springframework.beans.BeanUtils.copyProperties(source, target, COPY_IGNORED_PROPERTIES);
  }
  
  private static final String[] COPY_IGNORED_PROPERTIES = {"id", "dataChangeCreatedBy", "dataChangeCreatedTime", "dataChangeLastModifiedTime"};
}
