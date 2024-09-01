package com.quarkus.microservice.service.one.service;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;


public interface MessageService {

    Uni<Response> getWelcomeMessage();

    Uni<Response> createMessage(String message);

    Uni<Response> throwExceptionMessage();


}
