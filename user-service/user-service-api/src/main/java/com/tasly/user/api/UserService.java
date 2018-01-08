package com.tasly.user.api;

import com.tasly.user.dto.UserDTO;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dulei on 18/1/8.
 */
@FeignClient(value = "user-service")
public interface UserService {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    UserDTO getName(@PathVariable("id") String id);

}
