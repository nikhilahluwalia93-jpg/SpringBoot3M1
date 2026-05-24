package com.example.cones.SpringBoot3M1;

import com.example.cones.SpringBoot3M1.service.PaymentService;
import com.example.cones.SpringBoot3M1.service.PaymentService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot3M1Application  implements CommandLineRunner {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentService2 paymentService2;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot3M1Application.class, args);

        //PaymentService paymentService = context.getBean(PaymentService.class);
        //paymentService.pay();
    }

    @Override
    public void run(String... args) throws Exception {
        paymentService.pay();
        paymentService2.pay();
    }
}
