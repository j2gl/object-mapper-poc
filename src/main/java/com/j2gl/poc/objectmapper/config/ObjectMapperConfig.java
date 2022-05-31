package com.j2gl.poc.objectmapper.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@RequiredArgsConstructor
public class ObjectMapperConfig {

    private final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return jackson2ObjectMapperBuilder.build();
    }

    @Bean
    public ObjectMapper customObjectMapper() {
        return Jackson2ObjectMapperBuilder.json().build();
    }

}
