package com.tails.pricingservice.models;

import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "product_id",
        "price",
        "vat_band"
})
@Generated("jsonschema2pojo")
public class Price implements Serializable {

    private Integer product_id;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("vat_band")
    private String vatBand;
    private final static long serialVersionUID = -2215901033071708165L;

    public Integer getKey() {
        return product_id;
    }

    @JsonProperty("product_id")
    public Integer getProduct_id() {
        return product_id;
    }

    @JsonProperty("product_id")
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("vat_band")
    public String getVatBand() {
        return vatBand;
    }

    @JsonProperty("vat_band")
    public void setVatBand(String vatBand) {
        this.vatBand = vatBand;
    }

}