package com.example.billpayment.persistence;

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
    private final BillMapper billMapper;



    @Override
    public void addBill(AddBillRequestDto addBillRequestDto) {
        billRepository.save(billMapper.toBillEntity(addBillRequestDto));
    }
}
