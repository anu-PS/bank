package com.ps.anu.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.anu.bank.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
