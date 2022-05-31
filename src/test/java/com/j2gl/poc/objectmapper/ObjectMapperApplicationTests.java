package com.j2gl.poc.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class ObjectMapperApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("customObjectMapper")
    private ObjectMapper customObjectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testTowDifferentInstances() {
        log.info("objectMapper: {}", objectMapper);
        log.info("customObjectMapper: {}", customObjectMapper);
        assertThat(objectMapper).isNotEqualTo(customObjectMapper);
    }

}
