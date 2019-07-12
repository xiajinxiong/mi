package com.sure.mi.service;

import com.sure.mi.mapper.TransactionMapper;
import com.sure.mi.model.Transaction;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TransactionServiceImpl implements TransactionService{
    @Override
    public List<Transaction> displayTransactions(String username) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            TransactionMapper transactionMapper = sqlSession.getMapper(TransactionMapper.class);
            return transactionMapper.selectTransactionByUsername(username);
        }
        catch (Exception e) {
            return null;
        }
    }
}
