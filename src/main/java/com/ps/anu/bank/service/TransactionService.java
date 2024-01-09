package com.ps.anu.bank.service;

import com.ps.anu.bank.model.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public List<Transaction> findAllCustomersTransactions(String aadhar);
}
