package com.example.review.entity;

public class ReviewTest {

    public static Review review() {
        Review review =  new Review();
        review.setProductId("BB5476");
        review.setAverageReviewScore(4.5);
        review.setNumberOfReviews(21L);
        return review;
    }

}
