package com.example.billpayment.persistence.repository;

import com.example.billpayment.persistence.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
 

}
