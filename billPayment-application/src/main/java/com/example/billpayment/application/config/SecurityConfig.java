package com.example.billpayment.application.config;

import com.example.billpayment.service.impl.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    private final UserServiceImpl userDetailsService;

    public SecurityConfig(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()  // همه درخواست‌ها بدون احراز هویت
                )
                .csrf(csrf -> csrf.disable()) // غیرفعال کردن CSRF (برای راحتی تست API)
                .formLogin(form -> form.disable()) ;// غیرفعال کردن فرم لاگین

        return http.build();

//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/billPayment/loginUser",
//                                "/billPayment/register-user",
//                                "/swagger-ui/**",
//                                "/swagger-ui.html",
//                                "/swagger-ui/**",
//                                "/v3/api-docs",
//                                "/v3/api-docs/**",
//                                "/swagger-resources/**",
//                                "/webjars/**",
//                                "/h2-console/**",
//                                "/v3/api-docs/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())); // این خط مهمه برای H2 Console;
//
//        return http.build();
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/**"
////                                "/swagger-ui.html",
////                                "/swagger-ui/**",
////                                "/v3/api-docs",
////                                "/v3/api-docs/**",
////                                "/swagger-resources/**",
////                                "/webjars/**",
////                                "/h2-console/**"
//                        ).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults())
//                .csrf(csrf -> csrf.disable())
//                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
//
//        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }
}
