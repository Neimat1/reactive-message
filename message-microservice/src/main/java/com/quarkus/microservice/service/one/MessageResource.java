package com.quarkus.microservice.service.one;

import com.quarkus.microservice.service.one.service.MessageService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/async/message")
public class MessageResource {


    private final MessageService messageService;

    @Inject
    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getWelcomeMessage() {
        return messageService.getWelcomeMessage();
    }

    @POST
    @Path("/create-message")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Response> createMessage(String message) {
        return messageService.createMessage(message);
    }

    @POST
    @Path("/throw-exception")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> throwExceptionMessage() {
        return messageService.throwExceptionMessage();
    }


}
