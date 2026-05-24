package com.example.cones.SpringBoot3M1.service.impl;

import com.example.cones.SpringBoot3M1.service.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@Qualifier("EMAIL")
//@ConditionalOnProperty(name="notification.type", havingValue = "email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Example notification logic
        System.out.println("Notification sent via EMAIL: " + message);
    }
}

