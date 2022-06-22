package com.example.product.controller;

import com.example.product.domain.ProductTest;
import com.example.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductById_whenValidRequest_returnsValidResponse() throws Exception {
        when(productService.getProductById(anyString())).thenReturn(ProductTest.product());

        mockMvc.perform(get("/product/BB5476"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.id", equalTo("BB5476")))
            .andExpect(jsonPath("$.product_type", equalTo("inline")))
            .andExpect(jsonPath("$.model_number", equalTo("IAZ12")))
            .andExpect(jsonPath("$.name", equalTo("Gazelle Shoes")));
    }

    @Test
    public void createProduct_whenUnsupportedHttpVerb_returnsForbidden() throws Exception {
        mockMvc.perform(post("/product/BB5476"))
            .andExpect(status().isMethodNotAllowed())
            .andExpect(jsonPath("$.message", equalTo("Method Not Allowed")))
            .andExpect(jsonPath("$.debugMessage", equalTo("Request method 'POST' not supported")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
