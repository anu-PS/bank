package com.ps.anu.bank.service.impl;

import com.ps.anu.bank.dao.CustomerDao;
import com.ps.anu.bank.model.dto.Customer.DepositDto;
import com.ps.anu.bank.model.dto.Customer.WithdrawDto;
import com.ps.anu.bank.model.entity.Transaction;
import com.ps.anu.bank.model.enums.TransactionType;
import com.ps.anu.bank.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.anu.bank.model.dto.Customer.CustomerDto;
import com.ps.anu.bank.model.entity.Customer;
import com.ps.anu.bank.repository.CustomerRepository;
import com.ps.anu.bank.service.CustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository cr;

    @Autowired
    private TransactionService ts;

    @Autowired
    private ModelMapper mp;

    @Autowired
    private CustomerDao cdao;

    @Override
    public CustomerDto registerNewCustomer(CustomerDto dto) {
        return mp.map(cr.save(mp.map(dto, Customer.class)), CustomerDto.class);
    }

    @Override
    public CustomerDto depositMoney(DepositDto dto) {
        Optional<Customer> opt = cr.findById(dto.getAadhar());
        if (opt.isEmpty()) return null;
        Customer c = opt.get();
        cdao.setBalance(c.getBalance());
        cdao.deposit(dto.getAmount());
        c.setBalance(cdao.getBalance());

        Transaction t = new Transaction(null, dto.getAmount(), TransactionType.DEPOSIT, c);

        ts.saveTransaction(t);
        return mp.map(c, CustomerDto.class);
    }

    @Override
    public CustomerDto withdrawMoney(WithdrawDto dto) {
        Optional<Customer> opt = cr.findById(dto.getAadhar());
        if (opt.isEmpty()) return null;
        Customer c = opt.get();
        cdao.setBalance(c.getBalance());
        cdao.withdraw(dto.getAmount());
        c.setBalance(cdao.getBalance());

        Transaction t = new Transaction(null, dto.getAmount(), TransactionType.DEPOSIT, c);

        ts.saveTransaction(t);
        return mp.map(c, CustomerDto.class);
    }

    @Override
    public Customer getCustomerWithTransactions(String aadhar) {
        Customer c = cr.findById(aadhar).get();
        return c;
    }

}
