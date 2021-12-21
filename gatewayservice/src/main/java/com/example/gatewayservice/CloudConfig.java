package com.example.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author: GMO_DuyDV
 * @version: 1.0
 * @since: 12/17/2021
 * Project_name: GMO_QuanLyTaiSan
 */

@Configuration
public class CloudConfig {
    @Bean
    public RouteLocator getWayRoutes(RouteLocatorBuilder routeLocatorBuilder){
        System.out.println(routeLocatorBuilder.toString());
        return routeLocatorBuilder.routes()
                .route(r->
                            r.path("/user/**").uri("http://localhost:8083")
                        )
                .route(r->
                        r.path("/admin/**")
                                .uri("http://localhost:9001/")
                        )
                .build();
    }
}
