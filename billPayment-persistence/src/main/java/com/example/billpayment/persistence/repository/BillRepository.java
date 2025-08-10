package com.example.billpayment.persistence.repository;

import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByUser_Username(String username);
}