package com.ps.anu.bank.annotation.impl;

import com.ps.anu.bank.annotation.EnumValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, CharSequence> {

    private EnumValidator annotation;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

        if (value == null)
            return true;

        Object[] values = annotation.enumClass().getEnumConstants();
        for (Object val : values) {
            if (val.toString().equals(value.toString())
                    || (annotation.ignoreCase() && value.toString().equalsIgnoreCase(val.toString()))) {
                return true;
            }
        }

        return false;
    }

}
