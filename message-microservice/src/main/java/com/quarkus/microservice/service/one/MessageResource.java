package com.quarkus.microservice.service.one;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.Duration;

@Path("/api/async/message")
public class MessageResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> hello() {
        return Uni.createFrom()
                .item(Response.ok().entity("That's Our Welcome message: A huge welcome").build())
                .onItem().delayIt().by(Duration.ofSeconds(3));
    }
}
