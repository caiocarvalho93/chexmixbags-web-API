package com.kenzie.appserver.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.kenzie.appserver.repositories")
public class DynamoDbConfig {

    //this class is a Spring configuration class for DynamoDB/helps set up connections to Amazon DynamoDB/2 ways
    //provides two beans for creating instances of AmazonDynamoDB,Allows the application to interact with DynamoDB, storing and retrieving data.
    //1.conditional,allows you to override the DynamoDB endpoint if a specific property is set to "true"/custom
    //2.creates a default instance without overriding the endpoint

    //Other parts of the program can use these connections to read from or write to DynamoDB




    //injects the DynamoDB override endpoint property
    @Value("${dynamodb.override_endpoint}")
    String dynamoOverrideEndpoint;

    // Bean creation for AmazonDynamoDB conditionally based on the override endpoint property
    @Bean
    @ConditionalOnProperty(name = "dynamodb.override_endpoint", havingValue = "true")
    public AmazonDynamoDB amazonDynamoDB(@Value("${dynamodb.endpoint}") String dynamoEndpoint) {
        AwsClientBuilder.EndpointConfiguration endpointConfig = new
                AwsClientBuilder.EndpointConfiguration(dynamoEndpoint,
                "us-east-1");

        // Build and return the AmazonDynamoDB instance
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfig)
                .build();

    }
    // Bean creation for the default AmazonDynamoDB client
    @Bean(name = "amazonDynamoDB")
    public AmazonDynamoDB defaultAmazonDynamoDb() {
        // Build and return the default AmazonDynamoDB client
        return AmazonDynamoDBClientBuilder.defaultClient();
    }
}
