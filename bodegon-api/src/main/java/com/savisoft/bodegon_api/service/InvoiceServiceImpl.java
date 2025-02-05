package com.savisoft.bodegon_api.service;

import com.savisoft.bodegon_api.entity.Invoice;
import com.savisoft.bodegon_api.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findById(id).get();
        if(invoice.getDescription() != null){
            invoiceDB.setDescription(invoice.getDescription());
        }
        if(invoice.getRentalValue() != null){
            invoiceDB.setRentalValue(invoice.getRentalValue());
        }
        if(invoice.getAdvancePaymentValue() != null){
            invoiceDB.setAdvancePaymentValue(invoice.getAdvancePaymentValue());
        }
        if(invoice.getDepositValue() != null){
            invoiceDB.setDepositValue(invoice.getDepositValue());
        }
        if(invoice.getTotalValue() != null){
            invoiceDB.setTotalValue(invoice.getTotalValue());
        }
        if(invoice.getRentalInfo() != null){
            invoiceDB.setRentalInfo(invoice.getRentalInfo());
        }
        if(invoice.getState() != null){
            invoiceDB.setState(invoice.getState());
        }
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice findInvoiceById(Long id) {
        return invoiceRepository.findById(id).get();
    }

    //----------------Methods to get information about the Invoice Entity---------

    @Override
    public List<Invoice> findAllInvoicesByCustomerId(Long customerId) {
        return invoiceRepository.findAllInvoicesByCustomerId(customerId);
    }
}
