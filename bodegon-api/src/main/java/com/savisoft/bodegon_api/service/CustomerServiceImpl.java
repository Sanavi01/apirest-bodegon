package com.savisoft.bodegon_api.service;

import com.savisoft.bodegon_api.entity.Customer;
import com.savisoft.bodegon_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllCustomersByFirstName(String firstName) {
        return customerRepository.findCustomerByFirstNameContaining(firstName);
    }

    @Override
    public List<Customer> findAllCustomersByLastName(String lastName) {
        return customerRepository.findCustomerByLastNameContaining(lastName);
    }

    @Override
    public Customer updateCustomerById(Long id,Customer customer) {
        Customer customerDB = customerRepository.findById(id).get();
        if(customer.getFirstName() != null){
            customerDB.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName() != null){
            customerDB.setLastName(customer.getLastName());
        }
        if(customer.getPhoneNumber() != null){
            customerDB.setPhoneNumber(customer.getPhoneNumber());
        }
        if(customer.getHomeAddress() != null){
            customerDB.setHomeAddress(customer.getHomeAddress());
        }

        return customerRepository.save(customerDB);
    }
}
