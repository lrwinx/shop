package com.tasly.order.core.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by dulei on 18/1/9.
 */
@FeignClient(value = "order-service")
public interface OrderService {

}
