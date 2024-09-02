package com.quarkus.microservice.service.two;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class RestClientResourceTest {

    @Test
    public void shouldGetWelcomeMessage() {
        given()
                .when().get("/api/rest-client")
                .then().statusCode(200).body(is("Mocked Message"));
    }

    @Test
    public void shouldCreateNewMessage() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).body("Hi")
                .when().post("/api/rest-client/create-message")
                .then().statusCode(200).body(is("Mocked Message"));
    }

    @Test
    public void shouldThrowExceptionMessage() {
        given()
                .when().post("/api/rest-client/throw-exception")
                .then().statusCode(200).body(is("Mocked Message"));
    }

}
