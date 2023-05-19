package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name) {
        return "Greetings from " + name;
    }
} 