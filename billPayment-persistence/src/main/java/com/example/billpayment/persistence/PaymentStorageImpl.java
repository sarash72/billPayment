package com.example.billpayment.persistence;

import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.Payment;
import com.example.billpayment.persistence.entity.User;
import com.example.billpayment.persistence.mapper.PaymentMapper;
import com.example.billpayment.persistence.repository.BillRepository;
import com.example.billpayment.persistence.repository.PaymentRepository;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import com.example.billpayment.service.dto.payment.PaymentDto;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStorageImpl implements PaymentServiceApi {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final BillRepository billRepository;

    @Override
    public void savePayment(PaymentDto paymentDto) {
        Bill bill = billRepository.findByBillId(paymentDto.getBillId());
        if (bill == null) {
            new RuntimeException("bill not found with id: " + paymentDto.getBillId());
        }
        Payment payment = paymentMapper.toPaymentEntity(paymentDto);
        payment.setBill(bill);
        paymentRepository.save(payment);
    }

}
