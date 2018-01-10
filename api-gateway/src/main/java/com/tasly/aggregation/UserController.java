package com.tasly.aggregation;

import com.tasly.user.api.UserService;
import com.tasly.user.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dulei on 18/1/10.
 */
@RequestMapping("/user/agg")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public UserDTO getCurrentInfo(){
        //安全对象拿到用户id
        return userService.get(1L);
    }
}
