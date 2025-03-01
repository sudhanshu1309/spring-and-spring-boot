package com.example.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // need a controller method to show the initial HTML form
    @GetMapping("/showform")
    public String helloWorldForm() {
        return "helloWorldForm";
    }

    // need a controller method to process the HTML form
    @GetMapping("/processform")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and add data to the model
    @GetMapping("/processformv2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        // return the view
        return "helloworld";
    }

    @PostMapping("/processformv3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model) {

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        // return the view
        return "helloworld";
    }
}

