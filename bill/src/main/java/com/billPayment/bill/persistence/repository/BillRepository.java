package com.billPayment.bill.persistence.repository;

import com.billPayment.bill.persistence.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
