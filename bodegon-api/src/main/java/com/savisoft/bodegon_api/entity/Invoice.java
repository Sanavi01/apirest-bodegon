package com.savisoft.bodegon_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "tbl_invoices"
)
public class Invoice {

    @Id
    @SequenceGenerator(
            name = "invoice_sequence",
            sequenceName = "invoice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "invoice_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String description;
    private Long rentalValue;
    private Long advancePaymentValue;
    private Long depositValue;
    private Long totalValue;
    private String rentalInfo;
    private String state;
    @CreationTimestamp
    private LocalDateTime creationDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime returnDate;

    //----------------- Entity Relation ----------------------
    @ManyToOne
    private Customer customer;

}
