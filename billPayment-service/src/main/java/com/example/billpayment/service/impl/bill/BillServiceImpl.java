package com.example.billpayment.service.impl.bill;

import com.example.billpayment.api.dto.bill.AddBillRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.UserAppService;
import com.example.billpayment.service.api.persistence.BillServiceApi;
import com.example.billpayment.service.api.persistence.UserServiceApi;
import com.example.billpayment.service.dto.user.MyUserDetails;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import com.example.billpayment.service.impl.bill.mapper.BillServiceMapper;
import com.example.billpayment.service.impl.user.mapper.UserServiceMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class BillServiceImpl implements BillAppService {

    private final BillServiceApi billServiceApi;
    private final BillServiceMapper billServiceMapper;

    public BillServiceImpl(BillServiceApi billServiceApi, BillServiceMapper billServiceMapper) {
        this.billServiceApi = billServiceApi;
        this.billServiceMapper = billServiceMapper;
    }

    @Override
    public void addBill(AddBillRequestApi addBillRequestApi) {
        billServiceApi.addBill(billServiceMapper.toAddBillRequestDto(addBillRequestApi));
    }
}

