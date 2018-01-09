package com.tasly.score.core.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dulei on 18/1/9.
 */
@FeignClient(value = "score-service")
public interface ScoreService {

    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    String getScore(@PathVariable("uid") Long uid);
}
