package com.example.demoPactConsumer.repository;

import com.example.demoPactConsumer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRepository {

    public User getUserByFirstName(String firstName){
        RestTemplate restTemplate = new RestTemplate();
        String providerUrl = System.getProperty("providerUrl");
        ResponseEntity<User> response
                = restTemplate.getForEntity( providerUrl+firstName, User.class);
        return response.getBody();
    }
}
