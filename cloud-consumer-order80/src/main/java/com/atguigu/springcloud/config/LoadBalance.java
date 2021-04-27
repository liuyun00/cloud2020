package com.atguigu.springcloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final Integer nextNumber(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while ( !this.atomicInteger.compareAndSet(current, next));
        return next;
    }

    public ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList){
        Integer index = this.nextNumber() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
