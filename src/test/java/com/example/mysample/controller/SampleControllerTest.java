package com.example.mysample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SampleController.class)
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthEndpointShouldReturnUp() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void helloEndpointShouldReturnGreeting() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, World!"));
    }

    @Test
    void helloEndpointWithNameShouldReturnCustomGreeting() throws Exception {
        mockMvc.perform(get("/api/hello").param("name", "Spring"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, Spring!"));
    }

    @Test
    void infoEndpointShouldReturnApplicationInfo() throws Exception {
        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application").value("MySample API"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    void echoEndpointShouldReturnPayload() throws Exception {
        String payload = "{\"test\": \"data\"}";
        mockMvc.perform(post("/api/echo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.received.test").value("data"));
    }
}

