package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final PasswordEncoder passwordEncoder;

    public ResponseEntity register(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByUsernameEqualsIgnoreCase(customer.getUsername());
        if (!optionalCustomer.isPresent()) {
           customer.setPassword(passwordEncoder.encode(customer.getPassword()));
           customerRepository.save(customer);
           return Rest.success(customer);
        }
        return Rest.fail("Username Fail : "+ customer.getUsername(), HttpStatus.BAD_REQUEST);
    }

}
