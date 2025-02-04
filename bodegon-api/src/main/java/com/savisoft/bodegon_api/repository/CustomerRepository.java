package com.savisoft.bodegon_api.repository;

import com.savisoft.bodegon_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByPhoneNumber(String phoneNumber);
    List<Customer> findCustomerByFirstNameContaining(String firstName);
    List<Customer> findCustomerByLastNameContaining(String lastName);


}
