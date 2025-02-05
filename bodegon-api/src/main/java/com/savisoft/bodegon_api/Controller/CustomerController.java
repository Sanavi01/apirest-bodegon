package com.savisoft.bodegon_api.Controller;

import com.savisoft.bodegon_api.entity.Customer;
import com.savisoft.bodegon_api.entity.Invoice;
import com.savisoft.bodegon_api.service.CustomerService;
import com.savisoft.bodegon_api.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/saveCustomer")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/findByPhoneNumber/{phoneNumber}")
    public Customer findCustomerByPhoneNumber(@PathVariable String phoneNumber){
        return customerService.findCustomerByPhoneNumber(phoneNumber);
    }

    @GetMapping("/findAllCustomersByFirstName")
    public List<Customer> findAllCustomersByFirstName(@RequestParam (value = "firstName", defaultValue = "null") String firstName){
        return customerService.findAllCustomersByFirstName(firstName);
    }

    @GetMapping("/findAllCustomersByLastName")
    public List<Customer> findAllCustomersByLastName(@RequestParam (value = "lastName", defaultValue = "null")  String lastName){
        return customerService.findAllCustomersByLastName(lastName);
    }

    @PutMapping("/updateCustomerById/{id}")
    public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomerById(id, customer);
    }

    //----------------Methods to get information about the Invoice Entity---------

    @GetMapping("/findAllInvoicesByCustomerId/{customerId}")
    public List<Invoice> findAllInvoicesByCustomerId(@PathVariable Long customerId){
        return invoiceService.findAllInvoicesByCustomerId(customerId);
    }
}
