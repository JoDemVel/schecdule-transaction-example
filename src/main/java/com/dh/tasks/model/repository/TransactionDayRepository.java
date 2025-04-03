package com.dh.tasks.model.repository;

import com.dh.tasks.model.domain.TransactionDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDayRepository extends JpaRepository<TransactionDay, Long> {
    void deleteAll();
}
