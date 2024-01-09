package com.ps.anu.bank.dao.impl;

import com.ps.anu.bank.constant.Constants;
import com.ps.anu.bank.dao.CustomerDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CustomerDaoImpl implements CustomerDao {
    private float balance;

    @Autowired
    Constants constants;

    @Override
    public void deposit(float amt) {
        this.balance += amt;
    }

    @Override
    public void withdraw(float amt) {
        // The count for transaction needs to be done for each customer independently
        // and hence needs to be stored in the entity.
        // if (balance.subtract(amount).compareTo(constants.getMinBalance()) == -1) {
        // System.out.println("Cannot withdraw"); // throw custom exception
        // return;
        // }

        if (balance - amt < constants.getMinBalance()) {
            System.out.println("Cannot withdraw"); // throw exception
            return;
        }

        this.balance -= amt;
    }
}
