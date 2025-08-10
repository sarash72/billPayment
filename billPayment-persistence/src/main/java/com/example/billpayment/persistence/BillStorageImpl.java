package com.example.billpayment.persistence;

import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.User;
import com.example.billpayment.persistence.mapper.BillMapper;
import com.example.billpayment.persistence.mapper.UserMapper;
import com.example.billpayment.persistence.repository.BillRepository;
import com.example.billpayment.persistence.repository.UserRepository;
import com.example.billpayment.service.api.persistence.BillServiceApi;
import com.example.billpayment.service.api.persistence.UserServiceApi;
import com.example.billpayment.service.dto.bill.AddBillRequestDto;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BillStorageImpl implements BillServiceApi {

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final BillMapper billMapper;


    @Override
    public void addBill(AddBillRequestDto addBillRequestDto) {
        User user = userRepository.findById(addBillRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + addBillRequestDto.getUserId()));
        Bill bill = billMapper.toBillEntity(addBillRequestDto);
        bill.setUser(user);
        billRepository.save(bill);
    }
}
