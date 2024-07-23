package com.service.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        .uri("lb://currency-exchange")
                )
                .route(predicateSpec -> predicateSpec.path("/currency-conversion/**")
                        .filters(f-> f.addRequestParameter("currency","INR"))
                        .uri("lb://currency-conversion"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion-feign/**")
                        .filters(f-> f.addRequestParameter("currency","INR"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
