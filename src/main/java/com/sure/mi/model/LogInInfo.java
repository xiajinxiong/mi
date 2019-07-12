package com.sure.mi.model;

import lombok.Data;

@Data
public class LogInInfo {

    private String username;
    private String pword;

    public LogInInfo(String username, String pword) {
        this.username = username;
        this.pword = pword;
    }
}
