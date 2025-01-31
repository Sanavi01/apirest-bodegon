package com.savisoft.bodegon_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_client")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client extends Person{

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence"
    )
    @GeneratedValue(
            generator = "client_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

}
