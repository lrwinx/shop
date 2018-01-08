package com.tasly.user.api;

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
    String getName(@PathVariable("id") String id);

}
