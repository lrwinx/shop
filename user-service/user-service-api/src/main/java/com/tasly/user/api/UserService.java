package com.tasly.user.api;

import com.tasly.user.dto.UserDTO;
import com.tasly.user.dto.UsernameAndPasswordDTO;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dulei on 18/1/8.
 */
@FeignClient(value = "user-service")
public interface UserService {

    @RequestMapping(method = RequestMethod.POST)
    UserDTO getByUsernameAndPasswordDTO(UsernameAndPasswordDTO usernameAndPasswordDTO);


    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    UserDTO get(@PathVariable("uid") Long uid);

}
