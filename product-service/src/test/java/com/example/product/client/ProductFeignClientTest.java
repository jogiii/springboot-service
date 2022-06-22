package com.example.product.client;

import com.example.product.domain.Product;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9091)
public class ProductFeignClientTest {

    @Autowired
    ProductFeignClient productFeignClient;

    @Test
    public void getProductById_whenValidClient_returnValidResponse() throws Exception {
        // Using WireMock to mock client API:
        stubFor(get(urlEqualTo("/api/products/BB5476"))
            .willReturn(aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .withBody(read("stubs/product.json"))));

        Product product = productFeignClient.getProductById("BB5476");

        // We're asserting if WireMock responded properly
        assertThat(product.getId()).isEqualTo("BB5476");
        assertThat(product.getProductType()).isEqualTo("inline");
        assertThat(product.getModelNumber()).isEqualTo("IAZ12");
        assertThat(product.getName()).isEqualTo("Gazelle Shoes");
        assertThat(product.getMetadata().getCanonical()).isEqualTo("//www.adidas.co.uk/gazelle-shoes/BB5476.html");
    }

    private String read(String location) throws IOException {
        return IOUtils.toString(new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
    }
}
