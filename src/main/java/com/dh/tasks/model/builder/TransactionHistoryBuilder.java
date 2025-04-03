package com.dh.tasks.model.builder;

import com.dh.tasks.model.domain.TransactionDay;
import com.dh.tasks.model.domain.TransactionHistory;
import org.springframework.beans.BeanUtils;

public class TransactionHistoryBuilder {
    private final TransactionHistory instance;

    public static TransactionHistory getInstance(TransactionDay transactionDay) {
        return (new TransactionHistoryBuilder()).setTransactionDay(transactionDay);
    }

    private TransactionHistoryBuilder() {
        instance = new TransactionHistory();
    }

    private TransactionHistory setTransactionDay(TransactionDay transactionDay) {
        BeanUtils.copyProperties(transactionDay, instance);
        return instance;
    }

    public TransactionHistory build() {
        return instance;
    }
}
