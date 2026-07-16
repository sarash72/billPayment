package com.billPayment.bill.application.mapper;


import com.billPayment.bill.application.dto.request.CreateBillRequest;
import com.billPayment.bill.application.dto.response.BillResponse;
import com.billPayment.bill.persistence.entity.Bill;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {

    BillResponse billToBillResponse(Bill bill);
    List<BillResponse> billListToBillResponseList(List<Bill> billList);
    CreateBillRequest billToCreateBillRequest(Bill bill);
    Bill createBillRequestToBill(CreateBillRequest createBillRequest);

}
