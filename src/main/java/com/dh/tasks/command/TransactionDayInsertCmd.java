package com.dh.tasks.command;

import com.dh.tasks.api.request.TransactionDayRequest;
import com.dh.tasks.command.core.Command;
import com.dh.tasks.command.core.CommandExecute;
import com.dh.tasks.model.builder.TransactionDayBuilder;
import com.dh.tasks.model.domain.TransactionDay;
import com.dh.tasks.model.repository.TransactionDayRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@CommandExecute
public class TransactionDayInsertCmd implements Command {

    @Setter
    private TransactionDayRequest transactionDayRequest;

    @Getter
    private TransactionDay transactionDay;

    private final TransactionDayRepository transactionDayRepository;

    public TransactionDayInsertCmd(TransactionDayRepository transactionDayRepository) {
        this.transactionDayRepository = transactionDayRepository;
    }

    public void execute(){
        TransactionDay transaction = TransactionDayBuilder.getInstance(transactionDayRequest);
        transactionDay = transactionDayRepository.save(transaction);
    }
}
