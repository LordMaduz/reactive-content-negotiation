package com.ruchira.content.negotiation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Reactive Content-Negotiation Service", version = "1.0", description = "Reactive Content-Negotiation Service"))
public class ContentNegotiationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentNegotiationApplication.class, args);
	}

}
