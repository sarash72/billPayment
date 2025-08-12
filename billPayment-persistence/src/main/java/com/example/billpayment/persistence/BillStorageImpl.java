package com.example.billpayment.persistence;

import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.User;
import com.example.billpayment.persistence.mapper.BillMapper;
import com.example.billpayment.persistence.repository.BillRepository;
import com.example.billpayment.persistence.repository.UserRepository;
import com.example.billpayment.service.api.persistence.BillServiceApi;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.bill.BillWithUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BillStorageImpl implements BillServiceApi {

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final BillMapper billMapper;


    @Override
    public void addBill(BillServiceDto addBillRequestDto) {
        User user = userRepository.findById(addBillRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + addBillRequestDto.getUserId()));
        Bill bill = billMapper.toBillEntity(addBillRequestDto);
        bill.setUser(user);
        billRepository.save(bill);
    }

    @Override
    public List<BillServiceDto> getBillByUsername(BillWithUserRequestDto billWithUserRequestDto) {
      return billMapper.toBillDtoList(billRepository.findByUser_Username(billWithUserRequestDto.getUsername()));
    }

    @Override
    public BillServiceDto getBillById(Long billId) {
        return billMapper.toBillDto(billRepository.findByBillId(billId));
    }


}
