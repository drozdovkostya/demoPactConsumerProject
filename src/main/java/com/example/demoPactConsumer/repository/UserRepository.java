package com.example.demoPactConsumer.repository;

import com.example.demoPactConsumer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRepository {

    public User getUserByFirstName(String firstName){
        RestTemplate restTemplate = new RestTemplate();
        System.getProperty("");
        ResponseEntity<User> response
                = restTemplate.getForEntity( "http://localhost:8095/findUser/"+firstName, User.class);
        return response.getBody();
    }
}
