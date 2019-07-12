package com.sure.mi.mapper;

import com.sure.mi.model.Transaction;

import java.util.List;

public interface TransactionMapper {

    List<Transaction> selectTransactionByUsername(String username);
}
