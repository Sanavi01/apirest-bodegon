package com.savisoft.bodegon_api.service;

import com.savisoft.bodegon_api.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Customer findCustomerByPhoneNumber(String phoneNumber);
    List<Customer> findAllCustomersByFirstName(String firstName);
    List<Customer> findAllCustomersByLastName(String lastName);
    Customer updateCustomerById(Long id,Customer customer);
}
