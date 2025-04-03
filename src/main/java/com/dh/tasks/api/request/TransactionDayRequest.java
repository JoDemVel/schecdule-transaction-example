package com.dh.tasks.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDayRequest {

    private String name;

    private String numTransaction;

    private double amount;

    private String type;
}
