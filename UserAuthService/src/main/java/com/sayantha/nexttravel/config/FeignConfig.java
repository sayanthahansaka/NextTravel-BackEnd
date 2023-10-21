package com.sayantha.nexttravel.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Extract the token from the current security context
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String token = JWTService.generateToken(user);  // this line assumes your JWTService can generate a token based on UserDetails

            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}
