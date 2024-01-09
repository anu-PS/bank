package com.ps.anu.bank.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.anu.bank.model.entity.Customer;
import com.ps.anu.bank.model.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCustomerAadhar(String aadhar);
}
