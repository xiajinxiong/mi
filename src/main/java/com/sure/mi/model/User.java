package com.sure.mi.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private long id;
    private String username;
    private String nickName;
    private String phone;
    private String pword;
    private String signature;
    private String hobby;
    private String address;
    private List<Pair> cart;
}
