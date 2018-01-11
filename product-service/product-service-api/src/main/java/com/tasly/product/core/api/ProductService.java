package com.tasly.product.core.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by dulei on 18/1/9.
 */
@FeignClient(value = "product-service")
public interface ProductService {

}
