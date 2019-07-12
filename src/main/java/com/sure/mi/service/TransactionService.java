package com.sure.mi.service;

import com.sure.mi.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> displayTransactions(String username);
}
