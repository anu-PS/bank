package com.ps.anu.bank.model.dto.Customer;

import com.ps.anu.bank.annotation.EnumValidator;
import com.ps.anu.bank.model.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @NotBlank(message = "Aadhar cannot be blank.")
    private String aadhar;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{1,15}$", message = "Invalid phone number format")
    private String phone;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @EnumValidator(enumClass = Gender.class, message = "Invalid input for type gender")
    private String gender;

    private float balance;

}
