package com.learningdeveloper.spendwise.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customConfig() {
        Map<String, SecurityScheme> stringSecuritySchemeMap = new HashMap<>();
        stringSecuritySchemeMap.put("BearerTokenScheme", bearerTokenScheme());

        Components components = new Components();
        components.securitySchemes(stringSecuritySchemeMap);

        return new OpenAPI()
                .info(new Info().description("Swagger for spendwise"))
                .addSecurityItem(new SecurityRequirement().addList("BearerTokenScheme"))
                .components(components);
    }

    @Bean
    public SecurityScheme bearerTokenScheme() {

        return new SecurityScheme()
                .scheme("bearer")
                .bearerFormat("JWT")
                .type(SecurityScheme.Type.HTTP);
    }
}
