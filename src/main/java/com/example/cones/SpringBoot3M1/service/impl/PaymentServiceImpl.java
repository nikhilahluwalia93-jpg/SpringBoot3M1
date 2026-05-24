package com.example.cones.SpringBoot3M1.service.impl;

import com.example.cones.SpringBoot3M1.service.PaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    public  void  pay(){
        System.out.println("Payment processed successfully.");
    }
    @PostConstruct
    //called after the bean is created and dependencies are injected, but before the bean is ready to be used
    public void init() {
        System.out.println("PaymentServiceImpl bean initialized.");
    }
    @PreDestroy
    //called before the bean is destroyed, allowing for cleanup tasks such as releasing resources or closing connections
    public void destroy() {
        System.out.println("PaymentServiceImpl bean destroyed.");
    }

    @Override
    public boolean processPayment(double amount, String source, String destination) {
        // TODO: Implement payment processing logic
        return true;
    }

    @Override
    public boolean refundPayment(String transactionId, double amount) {
        // TODO: Implement refund logic
        return true;
    }
}

