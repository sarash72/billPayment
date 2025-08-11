package com.example.billpayment.service;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.application.BillPaymentApplication;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.PaymentService;
import com.example.billpayment.service.api.persistence.BillServiceApi;
import com.example.billpayment.service.impl.bill.BillServiceImpl;
import com.example.billpayment.service.impl.bill.mapper.BillServiceMapper;
import com.example.billpayment.service.impl.payment.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BillPaymentApplication.class)
@AutoConfigureMockMvc
class PaymentServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @Test
    void testPayBill() throws Exception {
        PaymentResponseApi response = new PaymentResponseApi();
        response.setRefId("12345");

        when(paymentService.payBill(any(PaymentRequestApi.class))).thenReturn(response);

        mockMvc.perform(post("/billPayment/pay-bill")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"refId\": \"12345\" }")) // یا میتونی JSON رو دقیق بسازی
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.refId").value("12345"));

        verify(paymentService, times(1)).payBill(any(PaymentRequestApi.class));
    }

}
