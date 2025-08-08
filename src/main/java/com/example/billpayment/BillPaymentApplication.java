package com.example.billpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.billpayment")
@EntityScan("com.example.billpayment.persistence.entity")
@EnableJpaRepositories(basePackages = "com.example.billpayment.persistence.repository")
public class BillPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillPaymentApplication.class, args);
    }

}
