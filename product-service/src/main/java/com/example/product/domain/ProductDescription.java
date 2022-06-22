package com.example.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class ProductDescription {

    String title;
    String subtitle;
    String text;
    @JsonProperty("description_assets")
    DescriptionAssets descriptionAssets;
    List<String> usps;

}
