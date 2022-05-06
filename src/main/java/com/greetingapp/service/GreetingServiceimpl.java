package com.greetingapp.service;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceimpl implements GreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Using Interface for jpa repositry
     */
    @Autowired
    private GreetingRepository greetingRepository;

    /**
     * Taking greeting message in form of User entity
     */
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    /**
     * Creating and Uniq ID to Store message
     *
     * @param id
     * @return
     */
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    /**
     * Method to get the list of repository.
     *
     * @return - List all users in the repository.
     */
    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    /**
     * Method to update/edit the greetings.
     *
     * @return -  updated greeting
     */
    @Override
    public Greeting updateGreeting(Greeting greeting) {
        if (greetingRepository.findById(greeting.getId()).isPresent())
            return greetingRepository.save(greeting);
        else
            return new Greeting(-1, " Greeting not found!");
    }

}
