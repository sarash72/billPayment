package com.example.billpayment.api.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "user register", description = "user register service")
public class UserRequestDto {

    @Schema(name = "نام کاربر")
    private String username;

    private String fullName;

    private String phoneNumber;

}
