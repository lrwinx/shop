package com.tasly.account.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

/**
 * Created by dulei on 18/1/8.
 */
@FeignClient(value = "account-service")
public interface AccountService {


    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    BigDecimal remainTotalMoney(@PathVariable("uid") Long id);

}
