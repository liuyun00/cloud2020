package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
