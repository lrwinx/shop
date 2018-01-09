package com.tasly.score.core;

import com.tasly.score.core.api.ScoreService;
import com.tasly.user.api.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dulei on 18/1/9.
 */
@RestController
public class ScoreServiceImpl implements ScoreService {


    @Autowired
    private UserService userService;

    @Override
    public String getScore(@PathVariable("uid") Long uid) {
        return userService.get(uid).toString();
    }
}
