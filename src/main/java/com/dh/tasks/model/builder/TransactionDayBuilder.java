package com.dh.tasks.model.builder;

import com.dh.tasks.api.request.TransactionDayRequest;
import com.dh.tasks.model.domain.TransactionDay;
import org.springframework.beans.BeanUtils;

public class TransactionDayBuilder {

    private final TransactionDay instance;

    public static TransactionDay getInstance(TransactionDayRequest transactionDayRequest) {
        return (new TransactionDayBuilder()).setTransactionDayRequest(transactionDayRequest);
    }

    private TransactionDayBuilder() {
        instance = new TransactionDay();
    }

    public TransactionDay setTransactionDayRequest(TransactionDayRequest transactionDayRequest) {
        BeanUtils.copyProperties(transactionDayRequest, instance);
        return instance;
    }

    public TransactionDay build() {
        return instance;
    }
}
