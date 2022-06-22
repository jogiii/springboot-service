package com.example.review.service;


import com.example.common.exception.DataNotFoundException;
import com.example.review.dto.ReviewDto;
import com.example.review.entity.Review;
import com.example.review.mapper.ReviewMapper;
import com.example.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public Review getReview(String productId) {
        return reviewRepository.findById(productId).orElseThrow(() -> new DataNotFoundException(String.format("Data for given productId '%s' not found", productId)));
    }

    @Override
    public Review createReview(ReviewDto reviewDto) {
        return reviewRepository.save(reviewMapper.dtoToEntity(reviewDto));
    }

    @Override
    public Review updateReview(String productId, ReviewDto reviewDto) {
        Review review = reviewRepository.findById(productId).orElseThrow(() -> new DataNotFoundException(String.format("Data for given productId '%s' not found", productId)));
        return reviewRepository.save(reviewMapper.updateNonNullValuesToEntity(reviewDto, review));
    }

    @Override
    public void deleteReview(String productId) {
        Review review = reviewRepository.findById(productId).orElseThrow(() -> new DataNotFoundException(String.format("Data for given productId '%s' not found", productId)));
        reviewRepository.delete(review);
    }

}
