package com.product.onlineproduct.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
public class CartControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCartTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/cart?userId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(cartResponse));

    }

    private static final String cartResponse = "{" +
            "  \"userId\": 1," +
            "  \"itemDtoList\": [" +
            "    {" +
            "      \"productId\": 1," +
            "      \"quantity\": 1" +
            "    }," +
            "    {" +
            "      \"productId\": 2," +
            "      \"quantity\": 2" +
            "    }" +
            "  ]" +
            "}";

}
