package com.quarkus.microservice.service.two.proxy;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="message.proxy")
@Path("/api/async/message")
public interface MessageProxy {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response> getWelcomeMessage();

    @POST
    @Path("/create-message")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    Uni<Response> createMessage(String message);

    @POST
    @Path("/throw-exception")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response> throwExceptionMessage();
}
