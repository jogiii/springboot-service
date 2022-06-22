package com.example.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Metadata {

    String canonical;
    String description;
    String keywords;
    @JsonProperty("page_title")
    String pageTitle;
    @JsonProperty("site_name")
    String siteName;

}
