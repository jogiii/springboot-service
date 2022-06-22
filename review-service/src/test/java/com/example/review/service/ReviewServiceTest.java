package com.example.review.service;

import com.example.review.dto.ReviewDtoTest;
import com.example.review.entity.Review;
import com.example.review.entity.ReviewTest;
import com.example.review.mapper.ReviewMapper;
import com.example.review.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ReviewServiceTest {

    @MockBean
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void getReviewByProductId_whenValidDataSource_returnThatReview() {
        when(reviewRepository.findById(anyString())).thenReturn(Optional.of(ReviewTest.review()));

        Review review = reviewService.getReview("BB5476");

        assertThat(review.getProductId()).isEqualTo("BB5476");
        assertThat(review.getAverageReviewScore()).isEqualTo(4.5);
        assertThat(review.getNumberOfReviews()).isEqualTo(21L);
    }

    @Test
    public void createReview_whenValidDataSource_createThatReview() {
        when(reviewRepository.save(any(Review.class))).thenReturn(ReviewTest.review());

        Review review = reviewService.createReview(ReviewDtoTest.reviewDto());

        assertThat(review.getProductId()).isEqualTo("BB5476");
        assertThat(review.getAverageReviewScore()).isEqualTo(4.5);
        assertThat(review.getNumberOfReviews()).isEqualTo(21L);
    }

    @Test
    public void updateReview_whenValidDataSource_updateNumberOfReviews() {
        when(reviewRepository.findById(anyString())).thenReturn(Optional.of(ReviewTest.review()));
        when(reviewRepository.save(any(Review.class))).thenReturn(reviewMapper.updateNonNullValuesToEntity(ReviewDtoTest.updateReviewDto(), ReviewTest.review()));

        Review review = reviewService.updateReview("BB5476", ReviewDtoTest.updateReviewDto());

        assertThat(review.getProductId()).isEqualTo("BB5476");
        assertThat(review.getAverageReviewScore()).isEqualTo(4.5);
        assertThat(review.getNumberOfReviews()).isEqualTo(25L);
    }

}
