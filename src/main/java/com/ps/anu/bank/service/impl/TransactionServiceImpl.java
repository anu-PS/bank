package com.ps.anu.bank.service.impl;

import com.ps.anu.bank.model.entity.Transaction;
import com.ps.anu.bank.repository.TransactionRepository;
import com.ps.anu.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository tr;


    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return tr.save(transaction);
    }

    @Override
    public List<Transaction> findAllCustomersTransactions(String aadhar) {
        return tr.findByCustomerAadhar(aadhar);
    }
}
