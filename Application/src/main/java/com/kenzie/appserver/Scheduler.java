package com.kenzie.appserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
   //it schedules and performs an asynchronous task every 200 milliseconds


    // Create any asynchronous services

    @Autowired
    private AsynchronousService checkAsyncService;

   @Scheduled(fixedDelay = 200)//
    public void schedule() {
       checkAsyncService.executeAsynchronously();
   }
}
