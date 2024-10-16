package com.works.customValids;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CustomerTypeValid implements ConstraintValidator<CustomerType, String> {

    String[] arr = {"user", "customer", "admin", "super"};

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean status = Arrays.asList(arr).contains(value);
        if (status == false) {

        }
        return status;
    }

}
