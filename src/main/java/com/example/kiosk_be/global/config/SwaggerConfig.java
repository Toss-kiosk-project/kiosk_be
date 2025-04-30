package com.example.kiosk_be.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.kiosk_be.domain.*.controller"})
@OpenAPIDefinition(
        info = @Info(
                title = "Kiosk Project",
                description = "This Project is simple kiosk service",
                version = "1.0.0"
        )
)
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().components(new Components());
    }
}
