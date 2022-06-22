package com.example.product.controller;

import com.example.product.domain.Product;
import com.example.product.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public Product getProductById(@Parameter(name = "productId", example = "BB5476")@PathVariable String productId) {
        return productService.getProductById(productId);
    }

}
