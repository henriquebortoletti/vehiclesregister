package com.exercises.vehicles.register;


import com.exercises.vehicles.register.service.FactorialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FactorialTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FactorialService factorialService;

    @Test
    public void when_get_factorial_of_5_then_return_120() throws Exception {

        mockMvc.perform(get("/factorial/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(120));
    }

    @Test
    public void when_get_factorial_of_0_then_return_1() throws Exception {
        mockMvc.perform(get("/factorial/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(1));
    }
}
