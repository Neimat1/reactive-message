package com.quarkus.microservice.service.two.service;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public interface RestClientService {

    Uni<Response> getWelcomeMessage();

    Uni<Response> createMessage(String message);

    Uni<Response> throwExceptionMessage();
}
