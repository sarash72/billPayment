package com.example.billpayment.service.dto.user;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserRequestDto {

    private String username;

    private String fullName;

    private String phoneNumber;

    private String password;

}
