package com.quarkus.microservice.service.two;

import com.quarkus.microservice.service.two.service.RestClientService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/rest-client")
public class RestClientResource {

    @Inject
    RestClientService service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(delay = 3000, maxRetries = 4)
    @Operation(
            summary = "Get Welcome Message",
            description = "Consume Message Microservice - getWelcomeMessage endpoint "
    )
    public Uni<Response> getWelcomeMessage() {
        return service.getWelcomeMessage();
    }

    @POST
    @Path("/create-message")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Retry(delay = 3000, maxRetries = 4)
    @Operation(
            summary = "Create Message",
            description = "Consume Message Microservice - /create-message endpoint "
    )
    public Uni<Response> createMessage(String message) {
        return service.createMessage(message);
    }

    @POST
    @Path("/throw-exception")
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(delay = 3000, maxRetries = 4)
    @Operation(
            summary = "Throw Exception Message",
            description = "Consume Message Microservice - /throw-message endpoint "
    )
    public Uni<Response> throwExceptionMessage() {
        return service.throwExceptionMessage();
    }
}
