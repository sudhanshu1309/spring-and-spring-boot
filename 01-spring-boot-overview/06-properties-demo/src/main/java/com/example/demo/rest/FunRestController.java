package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // injecting properties for coach.name and team.name from application.properties file
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose a new endpoint for team info
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

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
