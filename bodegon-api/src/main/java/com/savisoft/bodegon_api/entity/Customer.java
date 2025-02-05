package com.savisoft.bodegon_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "tbl_customer",
        uniqueConstraints = @UniqueConstraint(columnNames = "phoneNumber")

)
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "customer_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @NotBlank(message = "Please, add first name")
    private String firstName;
    @NotBlank(message = "Please, add first name")
    private String lastName;
    @NotBlank(message = "Please, add phone number")
    @Length(
            min = 10, max = 10,
            message = "This number is not allowed"
    )
    private String phoneNumber;
    private String homeAddress;

    //----------------- Entity Relation ----------------------

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoiceList;

}
