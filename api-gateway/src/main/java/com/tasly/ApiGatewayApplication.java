package com.tasly;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {
  
  public static void main(String[] args) {
    new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
  }
  
}