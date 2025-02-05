package com.savisoft.bodegon_api.service;

import com.savisoft.bodegon_api.entity.Invoice;

import java.util.List;


public interface InvoiceService {

    Invoice saveInvoice(Invoice invoice);
    Invoice updateInvoice(Long id, Invoice invoice);
    Invoice findInvoiceById(Long id);
    List<Invoice> findAllInvoicesByCustomerId(Long customerId);

}
