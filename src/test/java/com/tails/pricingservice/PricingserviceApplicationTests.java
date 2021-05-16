package com.tails.pricingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tails.pricingservice.controllers.PricingController;
import com.tails.pricingservice.models.Orders;
import com.tails.pricingservice.models.PricingDetails;
import com.tails.pricingservice.service.PricingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
@WebMvcTest(PricingserviceApplication.class)
class PricingserviceApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PricingService service;

    @Test
    void contextLoads() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/computePrice")
                .content(new ObjectMapper()
                        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                        .writeValueAsString(loadRates()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello, World")));
    }

    private Orders loadRates() {
        Orders pricingDetails = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = PricingserviceApplication.class.getResourceAsStream("/input.json");
            pricingDetails = mapper.readValue(is, Orders.class);

        } catch (IOException e) {
            e.getMessage();
        }
        return pricingDetails;
    }

}
