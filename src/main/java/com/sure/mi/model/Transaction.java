package com.sure.mi.model;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {

    private long id;
    private String photo;
    private int state;
    private double price;
    private Date createdAt;

    public Transaction(long id, String photo, int state, double price, Date createdAt) {
        this.id = id;
        this.photo = photo;
        this.state = state;
        this.price = price;
        this.createdAt = createdAt;
    }
}
