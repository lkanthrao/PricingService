package com.tails.pricingservice.models;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prices",
        "vat_bands"
})
@Generated("jsonschema2pojo")
public class PricingDetails implements Serializable {

    @JsonProperty("prices")
    private List<Price> prices = null;
    @JsonProperty("vat_bands")
    private VatBands vatBands;
    private final static long serialVersionUID = 811840350224456808L;

    @JsonProperty("prices")
    public List<Price> getPrices() {
        return prices;
    }

    @JsonProperty("prices")
    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @JsonProperty("vat_bands")
    public VatBands getVatBands() {
        return vatBands;
    }

    @JsonProperty("vat_bands")
    public void setVatBands(VatBands vatBands) {
        this.vatBands = vatBands;
    }

}