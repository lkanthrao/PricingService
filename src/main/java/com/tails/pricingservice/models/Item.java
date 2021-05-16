package com.tails.pricingservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Item implements Serializable {

    @JsonProperty("product_id")
    private Integer productId;
    private Integer quantity;

    private Integer pricePerEach;
    private Double vat;

    private String vatBand;

    private double totalPrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPricePerEach() {
        return pricePerEach;
    }

    public void setPricePerEach(Integer pricePerEach) {
        this.pricePerEach = pricePerEach;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public String getVatBand() {
        return vatBand;
    }

    public void setVatBand(String vatBand) {
        this.vatBand = vatBand;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
