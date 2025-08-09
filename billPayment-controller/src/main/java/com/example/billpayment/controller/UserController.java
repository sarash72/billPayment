package com.example.billpayment.controller;


import com.example.billpayment.api.dto.user.LoginUserRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.api.facade.UserFacade;
import com.example.billpayment.service.api.UserAppService;
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

@RestController
@Slf4j
@RequestMapping(path = UserFacade.PATH)
//@RequiredArgsConstructor
public class UserController implements UserFacade {

    private final AuthenticationManager authenticationManager;
    private final UserAppService userAppService;

    public UserController(AuthenticationManager authenticationManager, UserAppService userAppService) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
    }

    @Override
    public void insertUser(@RequestBody RegisterUserRequestApi userRequestDto) {
        userAppService.insertUser(userRequestDto);
    }

    @Override
    public ResponseEntity<String> loginUser(@RequestBody LoginUserRequestApi userRequestDto) {
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // اینجا می‌تونی JWT بسازی یا فقط پیام موفقیت بدهی
            return ResponseEntity.ok("Login successful");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
