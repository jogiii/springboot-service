package com.example.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class Product {
    @JsonProperty("id")
    String id;
    @JsonProperty("model_number")
    String modelNumber;
    @JsonProperty("name")
    String name;
    @JsonProperty("meta_data")
    Metadata metadata;
    @JsonProperty("product_type")
    String productType;
    @JsonProperty("product_description")
    ProductDescription productDescription;
    @JsonProperty("recommendationsEnabled")
    Boolean isRecommendationsEnabled;
    @JsonProperty("pricing_information")
    PricingInformation pricingInformation;
    @JsonProperty("review")
    Review review;
}
