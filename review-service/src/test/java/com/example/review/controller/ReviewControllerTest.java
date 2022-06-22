package com.example.review.controller;

import com.example.review.dto.ReviewDtoTest;
import com.example.review.entity.ReviewTest;
import com.example.review.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void getReviewByProductId_whenValidRequest_returnsValidResponse() throws Exception {
        when(reviewService.getReview(anyString())).thenReturn(ReviewTest.review());

        mockMvc.perform(get("/review/BB5476"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.productId", equalTo("BB5476")))
            .andExpect(jsonPath("$.averageReviewScore", comparesEqualTo(4.5)))
            .andExpect(jsonPath("$.numberOfReviews", comparesEqualTo(21)));
    }

    @Test
    public void createReview_whenAccessTokenNotPassed_throwForbiddenError() throws Exception {
        mockMvc.perform(post("/review")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(ReviewDtoTest.reviewDto())))
            .andExpect(status().isForbidden())
            .andExpect(jsonPath("$.message", equalTo("Access Denied")))
            .andExpect(jsonPath("$.debugMessage", equalTo("Full authentication is required to access this resource")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
