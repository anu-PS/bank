package com.ps.anu.bank.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ps.anu.bank.model.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column
    private String aadhar;

    @Column
    private String name, email, phone, address;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private float balance;

    @OneToMany(mappedBy = "customer")
//    @JsonBackReference
    @JsonManagedReference
    private List<Transaction> transactions;

}
