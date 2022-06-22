package com.example.review;

import com.example.review.controller.ReviewController;
import com.example.review.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ReviewServiceApplicationTests {

    @Autowired
    private ReviewController reviewController;

    @Autowired
    private ReviewService reviewService;

    @Test
    void contextLoads() {
        assertThat(reviewController).isNotNull();
        assertThat(reviewService).isNotNull();
    }

}
