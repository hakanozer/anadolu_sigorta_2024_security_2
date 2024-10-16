package com.works.entities;

import com.works.customValids.CustomerType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Data
public class Customer {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    @CustomerType
    private String type;

}
