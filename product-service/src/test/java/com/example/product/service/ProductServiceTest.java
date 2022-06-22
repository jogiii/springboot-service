package com.example.product.service;

import com.example.product.client.ProductFeignClient;
import com.example.product.domain.Product;
import com.example.product.domain.ProductTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductFeignClient productFeignClient;

    @Autowired
    private ProductService productService;

    @Test
    public void getProductById_whenValidClientResponse_returnAllPosts() {
        when(productFeignClient.getProductById(anyString())).thenReturn(ProductTest.product());

        Product product = productService.getProductById("BB5476");

        assertThat(product.getId()).isEqualTo("BB5476");
        assertThat(product.getName()).isEqualTo("Gazelle Shoes");
        assertThat(product.getProductType()).isEqualTo("inline");
        assertThat(product.getModelNumber()).isEqualTo("IAZ12");
    }

}
