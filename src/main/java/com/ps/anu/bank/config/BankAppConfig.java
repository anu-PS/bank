 package com.ps.anu.bank.config;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 import com.ps.anu.bank.constant.Constants;

 @Configuration
 public class BankAppConfig {

 @Bean
 public Constants constants() {
 return new Constants();
 }

 }
