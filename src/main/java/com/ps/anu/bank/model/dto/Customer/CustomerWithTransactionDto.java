package com.ps.anu.bank.model.dto.Customer;

import com.ps.anu.bank.model.dto.Transaction.TransactionDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerWithTransactionDto {
    private CustomerDto customer;
    private TransactionDto transaction;

}
