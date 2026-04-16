package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        return http
            .csrf(csrf -> csrf.disable()) // ✅ disable CSRF
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/auth/**").permitAll()  // ✅ open APIs
                .anyExchange().permitAll()             // ⚠️ IMPORTANT CHANGE
            )
            .build();
    }
}