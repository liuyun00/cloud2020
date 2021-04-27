package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OrderHystrixService,fallback,paymentInfo_OK，/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "OrderHystrixService,fallback,paymentInfo_TimeOut，/(ㄒoㄒ)/~~";
    }
}
