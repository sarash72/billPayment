package com.example.billpayment.api.dto.bill;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "getBill", description = "get bill with user service")
public class BillWithUserRequestApi {

    private String username;
}
