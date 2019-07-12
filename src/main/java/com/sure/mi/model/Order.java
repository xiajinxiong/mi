package com.sure.mi.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private long id;
    private long versionId;
    private long userId;
    private int number;
    private int state;
    private Date createdAt;

    public Order(long versionId, long userId, int number, int state, Date createdAt) {
        this.versionId = versionId;
        this.userId = userId;
        this.number = number;
        this.state = state;
        this.createdAt = createdAt;
    }
}
