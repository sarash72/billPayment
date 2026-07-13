package com.example.billpayment.persistence.test;


import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.api.dto.enumeration.BillType;
import com.example.billpayment.api.dto.enumeration.Status;
import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentType;

import com.example.billpayment.api.exception.BillPaidException;
import com.example.billpayment.api.exception.NotFoundBillException;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.PaymentService;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.impl.bill.mapper.BillServiceMapper;
import com.example.billpayment.service.impl.payment.mapper.PaymentServiceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentStorageTest {
    @Mock
    private BillAppService billRepository;

    @Mock
    private PaymentServiceApi paymentServiceApi;

    @Mock
    private PaymentServiceMapper paymentMapper;

    @Mock
    private BillAppService billAppService;

    @Mock
    private BillServiceMapper billServiceMapper;

    @InjectMocks
    private PaymentService paymentServiceImpl;

    private PaymentRequestDto paymentRequestDto;
    private PaymentRequestApi paymentRequestApi;

    private BillApi bill;

    @BeforeEach
    void setup() {
        paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setBillId("1");

        paymentRequestApi.setPaymentType(PaymentType.CARD);
        paymentRequestApi.setBillId("1");

        bill = new BillApi();
        bill.setStatus(Status.UNPAID);
        bill.setBillType(BillType.ELECTRICITY);
        bill.setAmount(new BigDecimal(100));
    }

    @Test
    void testPayBillSuccess() throws NotFoundBillException, BillPaidException {
        when(billAppService.getBillByBillId("1")).thenReturn(null);
        when(billServiceMapper.toBillRequestDto(bill)).thenReturn(null);

        when(paymentMapper.toPaymentRequestDto(paymentRequestApi)).thenCallRealMethod(); // یا mock مناسبی بزار
        when(paymentMapper.toPaymentResponseApi(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // اجرای متد
        var response = paymentServiceImpl.payBill(paymentRequestApi);

        assertNotNull(response);
        assertNotNull(response.getRefId());

        verify(paymentServiceApi, times(1)).savePayment(any());
        assertEquals(Status.PAID, bill.getStatus());
    }


    @Test
    void testPayBillBillNotFound() {
        when(billAppService.getBillByBillId("1")).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            paymentServiceImpl.payBill(paymentRequestApi);
        });

        assertEquals("Bill not found.", exception.getMessage());
    }

    @Test
    void testPayBillAlreadyPaid() {
        bill.setStatus(Status.PAID);
        when(billAppService.getBillByBillId("1")).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            paymentServiceImpl.payBill(paymentRequestApi);
        });

        assertEquals("This bill is already paid.", exception.getMessage());
    }
}


