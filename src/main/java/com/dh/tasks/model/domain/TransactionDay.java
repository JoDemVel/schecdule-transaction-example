package com.dh.tasks.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "transaction_day")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String numTransaction;

    private Double amount;

    private String type;

    private LocalDateTime date;
}
