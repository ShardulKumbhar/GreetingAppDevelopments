package com.greetingapp.controller;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    /**
     * we always Autowire Interface
     */
    @Autowired
    private GreetingService greetingService;

    /*
    Getmapping URL to post key as name=Sharul
    or default value = World
    http://localhost:8080/home
    Postman = key-name value -Shardul
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}
