package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test")
    public CommonResult test(){
        return new CommonResult(200,"成功");
    }


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果{}",result);
        System.out.println("dafadsfaf");
        if(result>0){
            return new CommonResult(200,"成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(500,"失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查看结果{}",payment);
        if(payment!=null ){
            return new CommonResult(200,"成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(500,"失败");
        }
    }

//    @GetMapping("/payment/feign/timeout")
//    public String paymentFeignTimeout(){
//        log.info("模拟不超时");
//        return serverPort;
//    }
}
