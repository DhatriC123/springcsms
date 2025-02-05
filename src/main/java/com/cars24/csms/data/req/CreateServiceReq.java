package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
//import javax.validation.Valid;
//import javax.validation.constraints.*;

@Valid

public class CreateServiceReq {
    @Valid

    private String name;
    private double price;

    @Valid
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CreateServiceReq{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}