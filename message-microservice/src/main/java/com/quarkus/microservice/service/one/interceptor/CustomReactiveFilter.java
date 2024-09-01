package com.quarkus.microservice.service.one.interceptor;


import io.quarkus.vertx.web.RouteFilter;
import io.vertx.ext.web.RoutingContext;


public class CustomReactiveFilter {
    @RouteFilter
    void addCustomHeader(RoutingContext routingContext) {
        routingContext.response().putHeader("Custom-Header", "Message-Microservice");
        routingContext.next();
    }
}
