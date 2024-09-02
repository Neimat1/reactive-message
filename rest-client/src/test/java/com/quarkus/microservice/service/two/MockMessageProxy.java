package com.quarkus.microservice.service.two;

import com.quarkus.microservice.service.two.proxy.MessageProxy;
import io.quarkus.test.Mock;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Mock
@RestClient
public class MockMessageProxy implements MessageProxy {
    @Override
    public Uni<Response> getWelcomeMessage() {
        return getMockResponse();
    }

    @Override
    public Uni<Response> createMessage(String message) {
        return getMockResponse();
    }

    @Override
    public Uni<Response> throwExceptionMessage() {
        return getMockResponse();
    }

    private Uni<Response> getMockResponse() {
        return Uni.createFrom().item(Response.ok().entity("Mocked Message").build());

    }
}
