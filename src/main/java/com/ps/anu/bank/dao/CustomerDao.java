package com.ps.anu.bank.dao;

public interface CustomerDao {
    void deposit(float amt);
    void withdraw(float amt);
    float getBalance();
    void setBalance(float bal);
}
