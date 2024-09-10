package com.kenzie.appserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ConcurrentLinkedQueue;

@Configuration
public class ExecutorServiceConfig {

    //this configuration class sets up a ThreadPoolTaskExecutor bean->a service for managing background tasks in a Spring application
    //provides efficient thread management for handling asynchronous operations

    /**sets up a helper (task executor) that can handle multiple tasks at the same time in the background.
     This helps the application run smoothly and quickly, especially when there are lots of things to do
     **/


    //Creates a thread pool for handling asynchronous operations
    //Sets the minimum and maximum number of threads in the pool to 4
    //Provides a named prefix for threads to identify them easily

    // This method defines a TaskExecutor bean for managing background tasks.
    @Bean
    public TaskExecutor executorService() {
        // Create a ThreadPoolTaskExecutor, a type of TaskExecutor implementation.
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // Set the minimum and maximum number of threads in the pool to 4.
        executor.setCorePoolSize(4);

        executor.setMaxPoolSize(4);

        // Set a prefix for thread names to make them identifiable.
        executor.setThreadNamePrefix("default_task_executor_thread");

        // Initialize the executor with the configured settings.
        executor.initialize();

        // Return the configured executor as a bean for later use.
        return executor;
    }
}
