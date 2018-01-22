package com.tasly.score.core.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dulei on 18/1/9.
 */
@FeignClient(value = "score-service")
public interface TCCScoreService {

    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    String reduceScore(@RequestParam("score") Integer score);

}
