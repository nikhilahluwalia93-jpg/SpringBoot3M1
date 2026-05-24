package com.example.cones.SpringBoot3M1.service;

import org.springframework.stereotype.Service;

//@Service
// Using @Bean annotation in a @Configuration class
public class PaymentServiceImpl2 implements PaymentService2 {

    //create pay metho
    public  void  pay(){
        System.out.println("Payment2 processed successfully.");
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

