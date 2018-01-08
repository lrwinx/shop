package com.tasly.user.core;

import com.tasly.user.api.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dulei on 18/1/8.
 */
@RestController
public class UserServiceImpl implements UserService {

    @Override
    public String getName(@PathVariable("id") String id) {
        return "test";
    }
}
