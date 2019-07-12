package com.sure.mi.service;

import com.sure.mi.model.Order;
import com.sure.mi.model.OrderInfo;
import com.sure.mi.model.Transaction;

import java.util.Date;

public interface OrderService {

    boolean placeOrder(String username, OrderInfo orderInfo, Date createdAt);
    Transaction displayOrder(String username);
}
