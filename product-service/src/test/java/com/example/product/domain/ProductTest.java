package com.example.product.domain;

public class ProductTest {

    public static Product product() {
        return Product.builder()
            .id("BB5476")
            .name("Gazelle Shoes")
            .productType("inline")
            .modelNumber("IAZ12")
            .build();
    }

}
