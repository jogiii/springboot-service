package com.example.review.service;

import com.example.review.dto.ReviewDto;
import com.example.review.entity.Review;

public interface ReviewService {

    Review getReview(String productId);

    Review createReview(ReviewDto review);

    Review updateReview(String productId, ReviewDto review);

    void deleteReview(String productId);
}
