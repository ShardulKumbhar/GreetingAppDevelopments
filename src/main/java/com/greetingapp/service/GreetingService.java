package com.greetingapp.service;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;

public interface GreetingService {
     Greeting addGreeting(User user);

    /**
     *
     * @param id
     * @return
     */
   Greeting getGreetingById(long id);
}
