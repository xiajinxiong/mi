package com.sure.mi.model;

import lombok.Data;

@Data
public class LogUpInfo {

    private String username;
    private String pword;

    public LogUpInfo(String username, String pword, String phone) {
        this.username = username;
        this.pword = pword;
        this.phone = phone;
    }

    private String phone;
}
