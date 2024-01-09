package com.ps.anu.bank.model.dto.Transaction;

import com.ps.anu.bank.model.dto.Customer.CustomerDto;
import com.ps.anu.bank.model.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailsDto {

    private int id;
    private float amount;
    private TransactionType type;
    private CustomerDto customer;

}
