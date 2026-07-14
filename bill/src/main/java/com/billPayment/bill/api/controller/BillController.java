package com.billPayment.bill.api.controller;


import com.billPayment.bill.api.dto.request.CreateBillRequest;
import com.billPayment.bill.api.dto.response.BillResponse;
import com.billPayment.bill.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping()
    public ResponseEntity<BillResponse> createBills(@Valid @RequestBody CreateBillRequest createBillRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED).body(null);
    }


    @GetMapping()
    public ResponseEntity<BillResponse> getBills(){

        return ResponseEntity
                .status(HttpStatus.OK).body(null);    }
}
