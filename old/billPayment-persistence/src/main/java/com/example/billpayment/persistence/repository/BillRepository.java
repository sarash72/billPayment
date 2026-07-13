package com.example.billpayment.persistence.repository;

import com.example.billpayment.persistence.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByUser_Username(String username);
    Bill findByBillId(String billId);
}