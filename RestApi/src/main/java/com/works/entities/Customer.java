package com.works.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String username;
    private String password;
    private Boolean enabled;

    @ManyToMany
    List<Role> roles;

}
