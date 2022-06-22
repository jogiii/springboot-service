package com.example.review.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Review {

    @Id
    String productId;

    Double averageReviewScore;

    Long numberOfReviews;
}
