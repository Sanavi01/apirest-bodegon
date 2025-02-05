package com.savisoft.bodegon_api.repository;

import com.savisoft.bodegon_api.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
