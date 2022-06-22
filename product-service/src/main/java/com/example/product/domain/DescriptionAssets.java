package com.example.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class DescriptionAssets {

    @JsonProperty("image_url")
    String imageUrl;
    @JsonProperty("video_url")
    String videoUrl;
    @JsonProperty("poster_url")
    String posterUrl;

}
