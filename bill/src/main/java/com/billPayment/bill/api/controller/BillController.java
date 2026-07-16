package com.billPayment.bill.api.controller;


import com.billPayment.bill.application.dto.request.CreateBillRequest;
import com.billPayment.bill.application.dto.response.BillResponse;
import com.billPayment.bill.application.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping()
    public ResponseEntity<BillResponse> createBills(@Valid @RequestBody
                                                    CreateBillRequest createBillRequest) {
        BillResponse billResponse = billService.createBill(createBillRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED).body(billResponse);
    }


    @GetMapping()
    public ResponseEntity<
            List<BillResponse>> getBills() {

        return ResponseEntity
                .status(HttpStatus.OK).body(billService.getBills());
    }
}
