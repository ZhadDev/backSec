package com.module.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurations {
    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**")
                        .allowedOrigins("*")// Solo en pruebas
                        .allowedMethods("GET", "POST", "DELETE");
            }
        };
    }
}
