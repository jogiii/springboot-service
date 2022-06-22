package com.example.product.service;

import com.example.product.client.ProductFeignClient;
import com.example.product.client.ReviewFeignClient;
import com.example.product.domain.Product;
import com.example.product.domain.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductFeignClient productFeignClient;
    private final ReviewFeignClient reviewFeignClient;

    @Override
    public Product getProductById(String productId) {
        Product product = productFeignClient.getProductById(productId);

        Review review = null;
        try {
            review = reviewFeignClient.getReviewByProduct(productId);
        }catch(Exception ex){
            log.error("Error while fetching reviews for product", ex);
        }
        product.setReview(review);
        return product;
    }
}
