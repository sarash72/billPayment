package com.example.billpayment.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class configuration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // اجازه دسترسی آزاد به H2 Console
                        .anyRequest().authenticated()                  // بقیه مسیرها نیاز به لاگین دارن
                )
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.disable())                       // غیرفعال کردن CSRF برای H2 Console
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())); // غیرفعال کردن FrameOptions برای iframe

        return http.build();
    }
}
