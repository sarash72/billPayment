package com.example.billpayment.api.dto.user;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "userLogin", description = "user login service")
public class LoginUserRequestApi {

    private String username;

    private String password;


}
