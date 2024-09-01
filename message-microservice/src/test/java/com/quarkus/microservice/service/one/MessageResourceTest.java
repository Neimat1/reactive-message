package com.quarkus.microservice.service.one;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class MessageResourceTest {
    @ConfigProperty(name = "welcome.message")
    private String WELCOME_MESSAGE;

    @Test
    public void shouldGetWelcomeMessage() {
        given()
                .when().get("/api/async/message")
                .then().statusCode(200).body(is(WELCOME_MESSAGE));
    }

    @Test
    public void shouldCreateNewMessage() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).body("Hi")
                .when().post("/api/async/message/create-message")
                .then().statusCode(201).body(is("success"));
    }

    @Test
    public void shouldThrowExceptionMessage() {
        given()
                .when().post("/api/async/message/throw-exception")
                .then().statusCode(500).body("details", startsWith("Error id"));
    }
}
