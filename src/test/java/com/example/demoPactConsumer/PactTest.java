package com.example.demoPactConsumer;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.demoPactConsumer.model.User;
import com.example.demoPactConsumer.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = "test_provider.base-url:http://localhost:8095",
        classes = UserRepository.class)
@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "test_provider", port = "8095")
public class PactTest {
    @Autowired
    private UserRepository userServiceRepository;

    @Pact(consumer =  "test_consumer")
    public RequestResponsePact pactUserExists(PactDslWithProvider builder) {
        return builder.given(
                "default")
                .uponReceiving("A request to /findUser/Vitalik")
                .path("/findUser/Vitalik")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonBody()
                        .integerType("age")
                        .stringType("postalCode")
                        .and("firstName","Vitalik")
                        .and("lastName","Johnson")
                        .stringType("position")
                        .integerType("id")
                )
                .toPact();
    }
    @PactTestFor(pactMethod = "pactUserExists")
    @Test
    public void userExists() {
        System.setProperty("providerUrl","http://localhost:8095");
        final User user = userServiceRepository.getUserByFirstName("Vitalik");
        assertThat(user.getFirstName().equals("Vitalik"));
    }
}
