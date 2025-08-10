package com.example.billpayment.persistence;

import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.Payment;
import com.example.billpayment.persistence.entity.Status;
import com.example.billpayment.persistence.repository.BillRepository;
import com.example.billpayment.persistence.repository.PaymentRepository;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentStorageImpl implements PaymentServiceApi {

    private final BillRepository billRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public PaymentResponseDto payBill(PaymentRequestDto paymentRequestDto) {
        // پیدا کردن قبض
        Optional<Bill> optionalBill = billRepository.findById(paymentRequestDto.getBillId());
        if (optionalBill.isEmpty()) {
            throw new RuntimeException("قبض پیدا نشد.");
        }

        Bill bill = optionalBill.get();

        if (bill.getStatus() == Status.PAID) {
            throw new RuntimeException("قبض قبلاً پرداخت شده است.");
        }

        String refId = UUID.randomUUID().toString();

        Payment payment = Payment.builder()
                .refId(refId)
                .paymentDate(LocalDate.now())
                .bill(bill)
                .build();

        paymentRepository.save(payment);

        bill.setStatus(Status.PAID);
        bill.setPayment(payment);
        billRepository.save(bill);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setRefId(refId);
        return paymentResponseDto;
    }

}
