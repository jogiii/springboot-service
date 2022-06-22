package com.example.product.domain;

import lombok.Value;

@Value
public class Review {

    Double averageReviewScore;
    Long numberOfReviews;
}
