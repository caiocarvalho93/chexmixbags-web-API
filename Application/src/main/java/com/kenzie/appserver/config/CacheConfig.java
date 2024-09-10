package com.kenzie.appserver.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * this class helps set up and configure a caching mechanism using the Caffeine cache library in a Spring application.
     * Caching is used to optimize the performance of the application by storing and reusing frequently accessed data
     **/

    //goal is to make the program faster by saving and reusing important information that the program uses a lot
    //we are using Caffeine cache, cache Manager

    //set instructions for making a caching system using the Caffeine library

    // Create a Cache here if needed

//    @Bean
//    public CacheStore myCache() {
//        return new CacheStore(120, TimeUnit.SECONDS);
//    }

    // Define a CacheManager bean to manage caching
    @Bean
    public CacheManager cacheManager() {
        // Create a CaffeineCacheManager instance
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        // Set the Caffeine cache configuration
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    // Configure the behavior of the Caffeine cache
    Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                // Specify the expiration time after write (120 seconds in this case)
                .expireAfterWrite(120, TimeUnit.SECONDS)

                // Set the maximum size of the cache (100 elements in this case)
                .maximumSize(100)

                // Record cache statistics for monitoring purposes
                .recordStats();
    }

    @Bean
    public ModelMapper modelMapper() {
       return new ModelMapper();
    }
}