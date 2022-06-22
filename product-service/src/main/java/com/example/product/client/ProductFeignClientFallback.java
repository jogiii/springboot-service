package com.example.product.client;

import com.example.product.domain.Product;

public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getProductById(String productId) {
        return null;
    }

}
