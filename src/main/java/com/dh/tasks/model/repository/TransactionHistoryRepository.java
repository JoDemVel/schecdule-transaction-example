package com.dh.tasks.model.repository;

import com.dh.tasks.model.domain.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
}
