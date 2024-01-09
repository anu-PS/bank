package com.ps.anu.bank.model.dto.Transaction;

import com.ps.anu.bank.annotation.EnumValidator;
import com.ps.anu.bank.model.enums.TransactionType;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Integer id;
    private float amount;

    @EnumValidator(enumClass = TransactionType.class, message = "Not valid input for enum Transaction Type")
    private String type;

    @NotNull(message = "Customer Id cannot be null")
    private String customerId;

}