package com.tasly.user.core;

import com.tasly.user.api.UserService;
import com.tasly.user.db.domain.User;
import com.tasly.user.db.reposity.UserReposity;
import com.tasly.user.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.tasly.commons.utils.Beans.transfrom;


/**
 * Created by dulei on 18/1/8.
 */
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReposity userReposity;

    @Override
    public UserDTO getName(@PathVariable("id") String id) {

        User user = new User();
        user.setAge(24);
        user.setName("张三");

        return transfrom(UserDTO.class,user);
    }
}
