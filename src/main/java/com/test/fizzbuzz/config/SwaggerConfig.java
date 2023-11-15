package com.test.fizzbuzz.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiDefinition() {

        return new OpenAPI()
                .servers(List.of(
                                new Server().url("http://localhost:8080")
                                        .description("Local Server URL")
                        )
                )
                .info(new Info().title("Fizz Buzz API")
                        .description(
                                "<h2> Fiz Buzz Technical Test"
                        )
                        .version("1.0.0")
                        .contact(
                                new Contact().name("Bhiri Yosri")
                                        .email("yousribhiri@gmail.com")
                        )
                );
    }
}
