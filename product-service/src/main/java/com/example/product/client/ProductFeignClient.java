package com.example.product.client;

import com.example.product.config.FeignClientConfig;
import com.example.product.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-client",
    url = "${client.product.baseUrl}",
    configuration = FeignClientConfig.class,
    fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/api/products/{productId}")
    Product getProductById(@PathVariable String productId);
}
