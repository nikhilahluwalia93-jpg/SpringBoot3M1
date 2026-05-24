package com.example.cones.SpringBoot3M1;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.cones.SpringBoot3M1.service.NotificationService;
import com.example.cones.SpringBoot3M1.service.PaymentService;
import com.example.cones.SpringBoot3M1.service.PaymentService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class SpringBoot3M1Application  implements CommandLineRunner {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentService2 paymentService2;

    //Field DI , Avoid in production code, use constructor(BEST) or setter DI instead
    //@Autowired
    //NotificationService notificationService;

    //Constructor DI, BEST PRACTICE
   final NotificationService notificationService;// also we cant make field DI final,recomened to make it final for immutability and thread safety
   //public SpringBoot3M1Application(@Qualifier("EMAIL") NotificationService notificationService) {
   public SpringBoot3M1Application(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    /*
    how Spring resolved the dependency?
    1. By (return)Type
    2. if multiple Beans By Qualifier (Bean name) -> use name or @Qualifier annotation to specify which bean to inject
    public SpringBoot3M1Application(@Qualifier("SMS")NotificationService notificationService) {
    3. if still ambiguous By Primary -> use @Primary annotation to mark one bean as primary
     */

    /*
    or conditional logic in @Bean method in @Configuration class(or self class) to decide which implementation to return based on some condition
    conditional can be in properties file or env variable or any other logic
     */

    //MiSC1 get all instance of bean
    @Autowired
    Map<String, NotificationService> notificationServices = new HashMap<>(); // TS, when we  want send notification on all available channels,


    //MiSC2 optional, if bean not found and we dont want to end uo in exception
    //@Autowired(required = false)
    //private PaymentService optionalPaymentService;// field DI

    /*
    public SpringBoot3M1Application(Optional<PaymentService> optionalPaymentService) {//const DI
        this.paymentService = optionalPaymentService.orElse(null);
    }*/

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot3M1Application.class, args);

        //PaymentService paymentService = context.getBean(PaymentService.class);
        //paymentService.pay();
    }

    @Override
    public void run(String... args) throws Exception {
        //paymentService.pay();
        //paymentService2.pay();
       // notificationService.sendNotification("Payment processed successfully.");
        //MiSC1 get all instance of bean

        for(var notificationService : notificationServices.entrySet()){
            System.out.println(notificationService.getKey());
            notificationService.getValue().sendNotification("Payment processed successfully.");
        }




    }
}
