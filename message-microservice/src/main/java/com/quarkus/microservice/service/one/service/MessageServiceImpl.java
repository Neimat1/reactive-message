package com.quarkus.microservice.service.one.service;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.time.Duration;

@ApplicationScoped
public class MessageServiceImpl implements MessageService {

    @ConfigProperty(name = "welcome.message")
    private String WELCOME_MESSAGE;

    @Inject
    Logger log;

    @Override
    public Uni<Response> getWelcomeMessage() {
        return Uni.createFrom()
                .item(Response.ok().entity(WELCOME_MESSAGE).build())
                .onItem().delayIt().by(Duration.ofSeconds(3));
    }

    @Override
    public Uni<Response> createMessage(String message) {
        log.info("Our new Message : " + message);
        return Uni.createFrom()
                .item(Response.status(201).entity("success").build());
    }

    @Override
    public Uni<Response> throwExceptionMessage() {
        return Uni.createFrom().failure(new Exception("General Exception !!!"));
    }
}
