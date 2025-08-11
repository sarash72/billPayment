package com.example.billpayment.persistence.test;


import com.example.billpayment.persistence.PaymentStorageImpl;
import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.BillType;
import com.example.billpayment.persistence.entity.Payment;
import com.example.billpayment.persistence.entity.Status;
import com.example.billpayment.persistence.repository.BillRepository;
import com.example.billpayment.persistence.repository.PaymentRepository;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    private BillRepository billRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentStorageImpl paymentStorage;

    private PaymentRequestDto paymentRequestDto;
    private Bill bill;

    @BeforeEach
    void setup() {
        paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setBillId(1L);

        bill = new Bill();
        bill.setId(1L);
        bill.setStatus(Status.UNPAID);
        bill.setBillType(BillType.GAS);
        bill.setAmount(new BigDecimal(100));
    }

    @Test
    void testPayBillSuccess() {
        when(billRepository.findById(1L)).thenReturn(Optional.of(bill));

        PaymentResponseDto response = paymentStorage.payBill(paymentRequestDto);

        assertNotNull(response);
        assertNotNull(response.getRefId());


        verify(paymentRepository, times(1)).save(any(Payment.class));
        verify(billRepository, times(1)).save(any(Bill.class));

        assertEquals(Status.PAID, bill.getStatus());
        assertNotNull(bill.getPayment());
        System.out.println("Payment refId: " + bill.getPayment().getRefId());

    }

    @Test
    void testPayBillBillNotFound() {
        when(billRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            paymentStorage.payBill(paymentRequestDto);
        });

        assertEquals("قبض پیدا نشد.", exception.getMessage());
    }

    @Test
    void testPayBillAlreadyPaid() {
        bill.setStatus(Status.PAID);
        when(billRepository.findById(1L)).thenReturn(Optional.of(bill));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            paymentStorage.payBill(paymentRequestDto);
        });

        assertEquals("قبض قبلاً پرداخت شده است.", exception.getMessage());
    }
}


