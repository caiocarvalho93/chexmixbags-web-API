package com.kenzie.appserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {
    /*
    @GetMapping("/")
    public ResponseEntity getServiceName() {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }*/

    // Endpoint to get the service name
    @GetMapping
    public ResponseEntity<String> getServiceName() {
        // Return a ResponseEntity with a 200 OK status and the service name in the response body
        return ResponseEntity.ok("Chex Mix Inventory Management Service");
    }
}
