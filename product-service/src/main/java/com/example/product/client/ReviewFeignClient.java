package com.example.product.client;

import com.example.product.config.FeignClientConfig;
import com.example.product.domain.Product;
import com.example.product.domain.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "review-client",
    url = "${client.review.baseUrl}")
public interface ReviewFeignClient {

    @GetMapping("/review/{productId}")
    Review getReviewByProduct(@PathVariable String productId);
}
