package com.sure.mi.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private String name;
    private String overview;
    private String detail;
    private List<Version> versions;
}
