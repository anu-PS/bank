package com.ps.anu.bank.model.dto.Transaction;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionListDto {
    private List<TransactionDto> transactions;
}
