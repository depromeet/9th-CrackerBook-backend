package com.depromeet.crackerbook.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion){
        Info info = new Info().title("CrackerBook API Document").version(appVersion)
                .description("CrackerBook API Document by swagger");
        return new OpenAPI().components(new Components()).info(info);
    }
}
