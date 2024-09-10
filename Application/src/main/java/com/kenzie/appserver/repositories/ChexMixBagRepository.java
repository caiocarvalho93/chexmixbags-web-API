package com.kenzie.appserver.repositories;

import com.kenzie.appserver.repositories.model.ChexMixBag;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ChexMixBagRepository extends CrudRepository<ChexMixBag, String> {
    // Additional Queries


    // Custom Queries based on requirements
    // You can add more methods based on your application needs


    // Add more methods as needed


}
