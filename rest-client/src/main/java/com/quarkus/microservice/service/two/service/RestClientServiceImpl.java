package com.quarkus.microservice.service.two.service;

import com.quarkus.microservice.service.two.proxy.MessageProxy;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class RestClientServiceImpl implements RestClientService {

    @Inject
    @RestClient
    MessageProxy proxy;

    @Override
    public Uni<Response> getWelcomeMessage() {
        return proxy.getWelcomeMessage().onFailure().recoverWithItem(
                failure -> {
                    return Response.status(Response.Status.OK).entity("Down time now, Will back soon!!").build();
                });
    }

    @Override
    public Uni<Response> createMessage(String message) {
        return proxy.createMessage(message).onFailure().recoverWithItem(
                failure -> {
                    return Response.status(Response.Status.OK).entity("Down time now, Will back soon!!").build();
                });
    }

    @Override
    public Uni<Response> throwExceptionMessage() {
        return proxy.throwExceptionMessage().onFailure().recoverWithItem(
                failure -> {
                    return Response.status(Response.Status.OK).entity("Down time now, Will back soon!!").build();
                });
    }
}

