package com.deemotron.toyap.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerSpecConfig {
    
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get()); // add RestController
            // Arrays.asList("api1", "api2")
            Arrays.asList("api2")
                .forEach(resourceName -> resources.add(loadResource(resourceName))); // add swagger.yaml
            return resources;
        };
    }

    private SwaggerResource loadResource(String resource) {
        SwaggerResource wsResource = new SwaggerResource();
        wsResource.setName(resource);
        wsResource.setSwaggerVersion("3.0");
        wsResource.setLocation("/swagger-apis/" + resource + "/swagger.yaml");
        return wsResource;
    }
}
