package com.example.billpayment.controller;


import com.example.billpayment.api.dto.user.LoginUserRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.api.facade.UserFacade;
import com.example.billpayment.service.api.UserAppService;
import com.example.billpayment.service.util.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(path = UserFacade.PATH)
//@RequiredArgsConstructor
@Tag(name = "User services", description = Constant.USER_CONTROLLER_DESCRIPTION)
public class UserController implements UserFacade {

    private final AuthenticationManager authenticationManager;
    private final UserAppService userAppService;
    private final JwtUtil jwtUtil;

    public UserController(AuthenticationManager authenticationManager, UserAppService userAppService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void insertUser(@RequestBody RegisterUserRequestApi userRequestDto) {
        userAppService.insertUser(userRequestDto);
    }

    @Override
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginUserRequestApi userRequestDto) {
        Map<String, String> response = new HashMap<>();

        try {
//            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtUtil.generateToken(userRequestDto.getUsername());

            response.put("token", token);
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            response.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }

    }

}



