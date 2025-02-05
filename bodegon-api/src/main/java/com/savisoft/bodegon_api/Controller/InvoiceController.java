package com.savisoft.bodegon_api.Controller;

import com.savisoft.bodegon_api.entity.Customer;
import com.savisoft.bodegon_api.entity.Invoice;
import com.savisoft.bodegon_api.service.CustomerService;
import com.savisoft.bodegon_api.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    CustomerService customerService;

    @PostMapping("/saveInvoice/{phoneNumber}")
    public Invoice saveInvoice(@RequestBody Invoice invoice,@PathVariable String phoneNumber){
        Customer customerDB =  customerService.findCustomerByPhoneNumber(phoneNumber);
        invoice.setCustomer(customerDB);
        return invoiceService.saveInvoice(invoice);
    }

    @PutMapping("/updateInvoice/{id}")
    public Invoice updateInvoice(@PathVariable Long id,@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(id,invoice);
    }
}
