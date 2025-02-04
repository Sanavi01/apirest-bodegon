package com.savisoft.bodegon_api.repository;

import com.savisoft.bodegon_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
