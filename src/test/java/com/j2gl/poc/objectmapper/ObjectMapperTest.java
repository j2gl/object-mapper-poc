package com.j2gl.poc.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.j2gl.poc.objectmapper.domain.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@AutoConfigureWebMvc
class ObjectMapperTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("customObjectMapper")
    private ObjectMapper customObjectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSpringbootObjectMapper() throws Exception {
        DataRequest request = getDataRequest();
        var jsonRequest = objectMapper.writeValueAsString(request);
        log.info("Request: {}", jsonRequest);

        DataRequest requestObject = objectMapper.readValue(jsonRequest,
                DataRequest.class);
        log.info("RequestObject: {}", requestObject);
    }

    @Test
    void testCustomObjectMapper() throws Exception {
        DataRequest request = getDataRequest();
        var jsonRequest = customObjectMapper.writeValueAsString(request);
        log.info("Request: {}", jsonRequest);

        try {
            DataRequest requestObject = customObjectMapper.readValue(jsonRequest,
                    DataRequest.class);
            log.info("RequestObject: {}", requestObject);
        } catch (InvalidDefinitionException e) {
            assertThat(e).isInstanceOf(InvalidDefinitionException.class);
            assertThat(e.toString()).contains("Cannot construct instance of");
        }
    }

    private DataRequest getDataRequest() {
        return DataRequest.builder()
                .number(1)
                .data("Test")
                .flag(true)
                .build();
    }
}
