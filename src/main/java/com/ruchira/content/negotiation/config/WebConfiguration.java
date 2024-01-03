package com.ruchira.content.negotiation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.accept.RequestedContentTypeResolverBuilder;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import java.util.Map;

@Configuration
public class WebConfiguration implements WebFluxConfigurer {

    @Override
    public void configureContentTypeResolver(RequestedContentTypeResolverBuilder builder) {
        builder.parameterResolver().mediaType(Map.of(
                "json", MediaType.APPLICATION_JSON,
                "xml", MediaType.APPLICATION_XML
        ));
        builder.headerResolver();
    }

}
