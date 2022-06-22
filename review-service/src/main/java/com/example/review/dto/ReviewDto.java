package com.example.review.dto;

import lombok.Data;

@Data
public class ReviewDto {

    String productId;
    Double averageReviewScore;
    Long numberOfReviews;
}
