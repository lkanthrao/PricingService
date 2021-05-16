package com.tails.pricingservice.models;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Orders implements Serializable {

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}