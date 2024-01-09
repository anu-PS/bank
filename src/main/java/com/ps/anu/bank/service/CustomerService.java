package com.ps.anu.bank.service;

import com.ps.anu.bank.model.dto.Customer.CustomerDto;
import com.ps.anu.bank.model.dto.Customer.DepositDto;
import com.ps.anu.bank.model.dto.Customer.WithdrawDto;
import com.ps.anu.bank.model.entity.Customer;

public interface CustomerService {
    CustomerDto registerNewCustomer(CustomerDto dto);

    CustomerDto depositMoney(DepositDto dto);

    CustomerDto withdrawMoney(WithdrawDto dto);

    Customer getCustomerWithTransactions(String aadhar);
}
