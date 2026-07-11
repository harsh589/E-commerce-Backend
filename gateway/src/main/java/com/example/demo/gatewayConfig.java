package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gatewayConfig {

    @Autowired
    private JwtFilter jwtFilter; // ✅ JWT filter inject

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()

                // 🟢 Product Service
                .route("product-service",
                        r -> r.path("/products/**")
                              .filters(f -> f.filter(jwtFilter.apply(new Object())))
                              .uri("lb://PRODUCT-SERVICE"))

                // 🔵 User Service (auth ke liye — login/register open)
                .route("user-service",
                        r -> r.path("/auth/**")
                              .filters(f -> f.filter(jwtFilter.apply(new Object())))
                              .uri("lb://USER-SERVICE"))

                // 🟠 Order Service (dono /order aur /orders handle)
                .route("order-service",
                        r -> r.path("/order/**", "/orders/**")   // ✅ dono ek saath
                              .filters(f -> f.filter(jwtFilter.apply(new Object())))
                              .uri("lb://ORDER-SERVICE"))

                .build();
    }
}