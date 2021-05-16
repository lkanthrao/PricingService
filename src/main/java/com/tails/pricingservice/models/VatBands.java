package com.tails.pricingservice.models;

import java.io.Serializable;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "standard",
        "zero"
})
@Generated("jsonschema2pojo")
public class VatBands implements Serializable {

    @JsonProperty("standard")
    private Double standard;
    @JsonProperty("zero")
    private Double zero;
    private final static long serialVersionUID = 6428948997985407915L;

    @JsonProperty("standard")
    public Double getStandard() {
        return standard;
    }

    @JsonProperty("standard")
    public void setStandard(Double standard) {
        this.standard = standard;
    }

    @JsonProperty("zero")
    public Double getZero() {
        return zero;
    }

    @JsonProperty("zero")
    public void setZero(Double zero) {
        this.zero = zero;
    }

}