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


//    @Override
//    @Transactional
//    public PaymentResponseDto payBill(PaymentRequestDto paymentRequestDto) {
//
//        /** پیدا کردن قبض
//         *
//         */
//        Optional<Bill> optionalBill = billRepository.findByBillId(paymentRequestDto.getBillId());
//        if (optionalBill.isEmpty()) {
//            throw new RuntimeException("قبض پیدا نشد.");
//        }
//
//        Bill bill = optionalBill.get();
//
//        if (bill.getStatus() == Status.PAID) {
//            throw new RuntimeException("قبض قبلاً پرداخت شده است.");
//        }
//
//        String refId = UUID.randomUUID().toString();
//
//        Payment payment = Payment.builder()
//                .refId(refId)
//                .paymentDate(LocalDate.now())
//                .bill(bill)
//                .build();
//
//        paymentRepository.save(payment);
//
//        bill.setStatus(Status.PAID);
//        bill.setPayment(payment);
//        billRepository.save(bill);
//
//        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
//        paymentResponseDto.setRefId(refId);
//        return paymentResponseDto;
//    }

//    @Override
//    public PaymentResponseDto payBill(PaymentRequestDto paymentRequestDto) {
//        return null;
//    }

    @Override
    public void savePayment(PaymentDto paymentDto) {
        System.out.println("1..........." + paymentDto.getBillId());
        Bill bill = billRepository.findByBillId(paymentDto.getBillId());
        if (bill == null) {
            new RuntimeException("bill not found with id: " + paymentDto.getBillId());
        }
        Payment payment = paymentMapper.toPaymentEntity(paymentDto);
        payment.setBill(bill);
        paymentRepository.save(payment);
    }

}
