package com.depromeet.crackerbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                        "http://localhost:3000"
//                        , "https://develop.d2tw5qtwawbqat.amplifyapp.com"
                        , "https://www.crackerbook.club/"
                )
        ;
        // TODO: production 환경에서는 localhost 제외
    }
}
