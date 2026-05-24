package com.example.cones.SpringBoot3M1.service.impl;

import com.example.cones.SpringBoot3M1.service.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("SMS")
//@ConditionalOnProperty(name="notification.type", havingValue = "sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Example notification logic
        System.out.println("Notification sent  via SMS: " + message);
    }
}

