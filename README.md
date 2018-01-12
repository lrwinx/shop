# 项目简介

1. 此商城项目，使用spring cloud 全家桶进行开发

2. 事务处理使用两种:强一致性(TCC),最终一致性(EDA)


## 使用技术

### java 8 : 使用lambda表达式，简化写法

### lombok : 简化java bean的写法

### H2 : 内存式数据库，减少DB依赖 (正式环境时，可以直接切换至MYSQL)

1. [H2的web客户端](https://github.com/lrwinx/shop/wiki/h2%E6%95%B0%E6%8D%AE%E5%BA%93%E7%9A%84web%E5%AE%A2%E6%88%B7%E7%AB%AF)

### spring cloud eureka : 用于服务注册发现

### spring data jpa : 数据库底层连接技术

### spring mvc : 访问控制层技术

### spring cloud robbin : 使用客户端负载均衡，进行服务提供者的调用

### spring cloud feign : 分装了ribbon的使用，直接使用注解的方式，进行调用

### spring boot actuate : spring boot项目的健康检查，此项目整合了应用服务的健康状态

### spring security : 权限管理

### spring cloud zuul : 网关服务，用来聚合和管理底层微服务接口

### spring cloud config : 集中配置管理，整合各个微服务下的不同配置文件


客户端需要启动定时任务@EnableScheduling这个注解,然后调用refresh接口，才起作用
     
    curl -X POST http://localhost:8001/refresh
    


## 项目分级

### 业务分级

此项目分为四个核心模块:

1. 用户模块(user-service):

1. 积分模块(score-service):

1. 产品模块(product-service):

1. 订单模块(order-service):


### 核心模块分层:

{模块名}-service-api: 微服务的模块api定义

{模块名}-service-core: 微服务的模块业务逻辑实现



