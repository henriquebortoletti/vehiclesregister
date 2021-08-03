package com.exercises.vehicles.register;

import com.exercises.vehicles.register.service.ElectorsService;
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
class ElectorsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ElectorsService electorsService;

    @Test
    void when_get_electors_votes_then_return_it() throws Exception {

        mockMvc.perform(get("/electors/votes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalElectors").value(1000))
                .andExpect(jsonPath("$.validVotesPercentage").value("80%"))
                .andExpect(jsonPath("$.whiteVotesPercentage").value("15%"))
                .andExpect(jsonPath("$.nullVotesPercentage").value("5%"));
    }

}
