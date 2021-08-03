package com.exercises.vehicles.register;

import com.exercises.vehicles.register.service.BubbleSortService;
import org.hamcrest.Matchers;
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
public class VectorOrderTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BubbleSortService bubbleSortService;

    @Test
    public void when_get_vector_order_then_return_it() throws Exception {

        mockMvc.perform(get("/vector/order")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.originalVector").value(Matchers.contains(5, 3, 2, 4, 7, 1, 0, 6)))
                .andExpect(jsonPath("$.orderedVector").value(Matchers.contains(0, 1, 2, 3, 4, 5, 6, 7)));

    }
}
