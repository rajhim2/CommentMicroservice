package com.microservice.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/demo_service")
public class MyController {
    @GetMapping
    public ResponseEntity<?> sampleApi(@RequestParam String sampleString) {
        return new ResponseEntity<>(sampleString, HttpStatus.OK);
    }
}

//Posts
// - Comments (CRUD)


