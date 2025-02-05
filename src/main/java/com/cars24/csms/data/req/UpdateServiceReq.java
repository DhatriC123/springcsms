package com.cars24.csms.data.req;

public class UpdateServiceReq {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String name;
    private Double price;



}
