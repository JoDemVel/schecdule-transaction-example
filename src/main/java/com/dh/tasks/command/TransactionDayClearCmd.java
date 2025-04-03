package com.dh.tasks.command;

import com.dh.tasks.command.core.Command;
import com.dh.tasks.model.repository.TransactionDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransactionDayClearCmd implements Command {

    private final TransactionDayRepository transactionDayRepository;

    public TransactionDayClearCmd(TransactionDayRepository transactionDayRepository) {
        this.transactionDayRepository = transactionDayRepository;
    }

    @Override
    public void execute() {
        transactionDayRepository.deleteAll();
    }
}
