package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void should_get_student_list() throws Exception {
        mockMvc.perform(get("/student-list"))
                .andExpect(jsonPath("$", hasSize(35)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void should_add_new_student() throws Exception {
        String jsonStr = "张三";

        mockMvc.perform(post("/student").content(jsonStr).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/student-list"))
                .andExpect(jsonPath("$", hasSize(36)))
                .andExpect(jsonPath("$[35].studentName", is("张三")))
                .andExpect(status().isOk());
    }
}
