package com.ps.anu.bank.controller;

import com.ps.anu.bank.model.dto.Customer.DepositDto;
import com.ps.anu.bank.model.dto.Customer.WithdrawDto;
import com.ps.anu.bank.model.entity.Customer;
import org.springframework.web.bind.annotation.*;

import com.ps.anu.bank.model.dto.Customer.CustomerDto;
import com.ps.anu.bank.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/customer")
//@Validated // This is causing error for some unbeknownst reason
public class CustomerController {

        @Autowired
        private CustomerService cs;

        @PostMapping("/register")
        private ResponseEntity<CustomerDto> registerNewCustomer(@RequestBody @Valid CustomerDto dto) {
                CustomerDto c = cs.registerNewCustomer(dto);
                return new ResponseEntity<>(c, HttpStatus.CREATED);

        }

        @PutMapping("/deposit")
        private ResponseEntity<CustomerDto> depositMoney(@RequestBody @Valid DepositDto dto) {
                CustomerDto c = cs.depositMoney(dto);
                return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
        }

        @PutMapping("/withdraw")
        private ResponseEntity<CustomerDto> withdrawMoney(@RequestBody @Valid WithdrawDto dto) {

                CustomerDto c = cs.withdrawMoney(dto);
                return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
        }

        @GetMapping("/transactions/{aadhar}")
        private ResponseEntity<Customer> getAllTransactionsOfCustomer(@PathVariable String aadhar) {
                Customer c = cs.getCustomerWithTransactions(aadhar);
                return new ResponseEntity<>(c, HttpStatus.OK);
        }

}
