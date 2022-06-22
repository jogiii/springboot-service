package com.example.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class PricingInformation {

    @JsonProperty("currentPrice")
    Double currentPrice;
    @JsonProperty("standard_price")
    Double standardPrice;
    @JsonProperty("standard_price_no_vat")
    Double standardPriceNoVat;
}
