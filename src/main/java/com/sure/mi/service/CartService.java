package com.sure.mi.service;

import com.sure.mi.model.CartItem;

import java.util.List;

public interface CartService {

    void addToCart(String username, String name, String version, String color);
    void dropItem(String username, String name, String version, String color);
    List<CartItem> displayItems(String username);
    void dropCart(String username, String name, String version, String color);
}
