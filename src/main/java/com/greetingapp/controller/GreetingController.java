package com.greetingapp.controller;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    /**
     * we always Autowire Interface
     */
    @Autowired
    private GreetingService greetingService;

    /**
     * Getmapping URL to post key as firstName=Sharul and lastName-Shardul
     * To add the given parameter lo the local repository and save the data into the h2 Database.
     * http://localhost:8080/home?firstName=Shardul&lastName=Kumbhar
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "first") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "last") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    /**
     * Method to find the Greeting Message using there id as a parameter.
     *
     * @param id
     * @return - Find the greeting message using ID.
     * URL - http://localhost:8080/find?id=2
     */
    @GetMapping("/find")
    public Greeting getGreetingById(@RequestParam(value = "id") long id) {
        return greetingService.getGreetingById(id);
    }

    /**
     * Method to list all the greeting Messages in the repository
     *
     * @return - List all the greeting messages in repository.
     * URL - http://localhost:8080/listAll
     */
    @GetMapping("/listAll")
    public List<Greeting> getAll() {
        return greetingService.getAll();
    }
}
