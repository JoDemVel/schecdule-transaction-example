package com.dh.tasks.model.builder;

import com.dh.tasks.api.request.TransactionDayRequest;
import com.dh.tasks.model.domain.TransactionDay;
import org.springframework.beans.BeanUtils;

public final class TransactionDayRequestBuilder {

    private final TransactionDayRequest instance;

    public static TransactionDayRequest getInstance(TransactionDay transactionDay) {
        return (new TransactionDayRequestBuilder()).setTransactionDayRequest(transactionDay);
    }

    private TransactionDayRequestBuilder() {
        instance = new TransactionDayRequest();
    }

    private TransactionDayRequest setTransactionDayRequest(TransactionDay transactionDay) {
        BeanUtils.copyProperties(transactionDay, instance);
        return instance;
    }

    private TransactionDayRequest build() {
        return instance;
    }
}
