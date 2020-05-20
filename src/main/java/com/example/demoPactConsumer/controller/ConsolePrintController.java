package com.example.demoPactConsumer.controller;

import com.example.demoPactConsumer.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConsolePrintController {
    UserRepository userRepository = new UserRepository();
    @GetMapping("consumeUser/{firstName}")
    public String consumeUser(@PathVariable String firstName){
        System.out.println("Message from provider: "+firstName);

        return "User returnde:  \n"+userRepository.getUserByFirstName(firstName);
    }

}
