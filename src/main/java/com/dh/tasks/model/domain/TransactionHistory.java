package com.dh.tasks.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistory {

    @Id
    private Long id;

    private String name;

    private String numTransaction;

    private Double amount;

    private String type;

    private LocalDateTime date;
}
