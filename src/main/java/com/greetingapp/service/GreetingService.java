package com.greetingapp.service;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;

import java.util.List;

public interface GreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<Greeting> getAll();
    Greeting updateGreeting(Greeting greeting);

    void deleteGreeting(long id);
}
