package com.tails.pricingservice.models;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Order implements Serializable {

    private Integer id;
    private Customer customer;
    private List<Item> items = null;

    private double totalPriceofCart;
    private double totalVat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPriceofCart() {
        return totalPriceofCart;
    }

    public void setTotalPriceofCart(double totalPriceofCart) {
        this.totalPriceofCart = totalPriceofCart;
    }

    public double getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(double totalVat) {
        this.totalVat = totalVat;
    }
}