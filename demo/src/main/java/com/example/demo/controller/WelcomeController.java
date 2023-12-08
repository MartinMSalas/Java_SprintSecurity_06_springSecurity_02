package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    @GetMapping("/hellopublic") // http://localhost:8080/api/welcome/hellopublic
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello World Public", HttpStatus.OK);
    }

    @GetMapping("/helloprotected") // http://localhost:8080/api/welcome/helloprotected
    public ResponseEntity<String> sayHelloProtected(){
        return new ResponseEntity<>("Hello World Protected", HttpStatus.OK);
    }
    @GetMapping("/hellouser") // http://localhost:8080/api/welcome/hellouser
    public ResponseEntity<String> sayHelloUser(){
        return new ResponseEntity<>("Hello World User", HttpStatus.OK);
    }
    @GetMapping("/helloadmin") // http://localhost:8080/api/welcome/helloadmin
    public ResponseEntity<String> sayHelloAdmin(){
        return new ResponseEntity<>("Hello World Admin", HttpStatus.OK);
    }
}
