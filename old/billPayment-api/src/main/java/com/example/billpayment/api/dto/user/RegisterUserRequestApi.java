package com.example.billpayment.api.dto.user;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "userRegister", description = "user register service")
public class RegisterUserRequestApi {

    private String username;

    private String fullName;

    private String phoneNumber;

    private String password;


}
