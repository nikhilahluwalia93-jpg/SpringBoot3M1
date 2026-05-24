package com.example.cones.SpringBoot3M1.service;
public interface PaymentService2 {
    void pay();
    boolean refundPayment(String transactionId, double amount);
    boolean processPayment(double amount, String source, String destination);
}

