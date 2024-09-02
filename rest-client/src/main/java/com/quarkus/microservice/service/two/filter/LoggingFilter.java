package com.quarkus.microservice.service.two.filter;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter,
        ContainerResponseFilter {
    @Inject
    Logger logger;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        logger.info("Request Received : \n" +
                "\t Request Method : " + containerRequestContext.getMethod() + "\n" +
                "\t Media Type : " + containerRequestContext.getMediaType() + "\n" +
                "\t Headers : " + containerRequestContext.getHeaders() + "\n");
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        logger.info("Response Sent : \n" +
                "\t Status  : " + containerResponseContext.getStatus() + "\n" +
                "\t Media Type : " + containerResponseContext.getMediaType() + "\n" +
                "\t Body  : " + containerResponseContext.getEntity() + "\n");
    }
}
