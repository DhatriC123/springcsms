package com.cars24.csms.data.resp;

import com.cars24.csms.data.enums.UserType;

public class DeleteServiceResponse {
    private UserType name;

    private double price;

    public UserType getName() {
        return name;
    }

    public void setName(UserType name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
