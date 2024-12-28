package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" endpoint
    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String getFortune() {
        return "Good luck!";
    }
}
