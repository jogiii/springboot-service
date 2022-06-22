package com.example.review.dto;

public class ReviewDtoTest {

    public static ReviewDto reviewDto() {
        ReviewDto review = new ReviewDto();
        review.setProductId("BB5476");
        review.setAverageReviewScore(4.5);
        review.setNumberOfReviews(21L);
        return review;
    }

    public static ReviewDto updateReviewDto() {
        ReviewDto review = new ReviewDto();
        review.setNumberOfReviews(25L);
        return review;
    }
}
