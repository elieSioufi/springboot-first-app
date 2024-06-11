package com.testcase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @PostMapping("/post")
    public ResponseEntity<Object> print (@RequestBody Object body) {
        return ResponseEntity.ok(body);
    }
}



