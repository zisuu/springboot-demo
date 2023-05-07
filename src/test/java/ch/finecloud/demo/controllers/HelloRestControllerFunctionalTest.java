package ch.finecloud.demo.controllers;

import ch.finecloud.demo.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetWithName() {
        Greeting result = restTemplate.getForObject("/rest?name=dummy", Greeting.class);
        assertEquals("Hello, dummy!", result.getMessage());
    }

    @Test
    void greetWithoutName() {
        ResponseEntity<Greeting> result = restTemplate.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, result.getHeaders().getContentType());
        Greeting greeting = result.getBody();
        if (greeting != null) {
            assertEquals("Hello, World!", greeting.getMessage());
        }
    }
}