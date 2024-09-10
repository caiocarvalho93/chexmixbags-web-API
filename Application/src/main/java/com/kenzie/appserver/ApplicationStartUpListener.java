package com.kenzie.appserver;


import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class ApplicationStartUpListener {
    //When my application starts or refreshes, to do something

    //When the Spring Boot application starts or the application context is refreshed,the ApplicationStartUpListener class,
    // with its onApplicationEvent method,allows us to define custom logic or tasks that should be executed


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Perform any application start-up tasks
        //a notification/message in the logs that the application has started, and any associated start-up tasks are being executed
        System.out.println("Application started. Performing start-up tasks...");
    }
}
