package com.sure.mi.model;

import lombok.Data;

@Data
public class CartItem {

    private String name;
    private String version;
    private String color;
    private double price;
    private String photo;
    private int number;

    public CartItem(String name, String version, String color, double price, String photo) {
        this.name = name;
        this.version = version;
        this.color = color;
        this.price = price;
        this.photo = photo;
    }
}
