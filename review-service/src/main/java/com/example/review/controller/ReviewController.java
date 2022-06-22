package com.example.review.controller;

import com.example.review.entity.Review;
import com.example.review.dto.ReviewDto;
import com.example.review.service.ReviewService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{productId}")
    public Review getReview(@Parameter(name = "productId", example = "BB5476") @PathVariable String productId) {
        return reviewService.getReview(productId);
    }

    @PostMapping
    public Review createReview(ReviewDto reviewDto) {
        return reviewService.createReview(reviewDto);
    }

    @PutMapping("/{productId}")
    @Parameters({
        @Parameter(name="Authorization", in = ParameterIn.HEADER, required = true, allowEmptyValue = false, example = "Bearer access_token")
    })
    public Review updateReview(@Parameter(name = "productId", example = "BB5476") @PathVariable String productId, ReviewDto reviewDto) {
        return reviewService.updateReview(productId, reviewDto);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteReview(@Parameter(name = "productId", example = "BB5476") @PathVariable String productId) {
        reviewService.deleteReview(productId);
        return ResponseEntity.ok().build();
    }
}
