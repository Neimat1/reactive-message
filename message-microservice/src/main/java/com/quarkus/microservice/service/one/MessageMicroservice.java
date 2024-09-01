package com.quarkus.microservice.service.one;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info( title = "Message Microservice",
                description = "Service-One which has 3 endpoints",
                version = "1.0"
        )
)
public class MessageMicroservice extends Application {
}
