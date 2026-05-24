package com.example.cones.SpringBoot3M1.config;

import com.example.cones.SpringBoot3M1.service.PaymentService2;
import com.example.cones.SpringBoot3M1.service.impl.PaymentServiceImpl;
import com.example.cones.SpringBoot3M1.service.impl.PaymentServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    PaymentService2 paymentService2() {
        //Todo: decide which implementation to use based on some condition
        // or any pre,post processing logic, before returning the instance
        return new PaymentServiceImpl2();
    }
    PaymentServiceImpl paymentService() {
        //Todo: this take precedence over the default component scan based bean creation, if there is a conflic
        // i.e it will ignore @Service annotation in PaymentServiceImpl class and use this method to create the bean
        return new PaymentServiceImpl();
    }
}
