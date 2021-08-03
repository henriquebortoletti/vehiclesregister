package com.exercises.vehicles.register;

import com.exercises.vehicles.register.service.MultiplesService;
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
public class MultiplesTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MultiplesService multiplesService;

    @Test
    public void when_get_multiples_sum_of_10_then_return_23() throws Exception {

        mockMvc.perform(get("/multiples/sum/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(23));
    }

    @Test
    public void when_get_multiples_sum_of_2_then_return_0() throws Exception {

        mockMvc.perform(get("/multiples/sum/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(0));
    }


}
