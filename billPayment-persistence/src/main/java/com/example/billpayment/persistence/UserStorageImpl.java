package com.example.billpayment.persistence;

import com.example.billpayment.persistence.mapper.UserMapper;
import com.example.billpayment.persistence.repository.UserRepository;
import com.example.billpayment.service.api.persistence.UserServiceApi;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserStorageImpl implements UserServiceApi {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private PasswordEncoder passwordEncoder;

    public UserStorageImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void insertUser(RegisterUserRequestDto user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userMapper.toUserEntity(user));

    }

    @Override
    public RegisterUserRequestDto findByUsername(String username) {
        return userMapper.toRegisterUserRequestDto(userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

}
