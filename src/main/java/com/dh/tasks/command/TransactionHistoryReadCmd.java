package com.dh.tasks.command;

import com.dh.tasks.command.core.Command;
import com.dh.tasks.model.domain.TransactionDay;
import com.dh.tasks.model.domain.TransactionHistory;
import com.dh.tasks.model.repository.TransactionDayRepository;
import com.dh.tasks.model.repository.TransactionHistoryRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransactionHistoryReadCmd implements Command {

    @Setter
    private Pageable pageable;

    @Getter
    private Page<TransactionHistory> transactions;

    private final TransactionHistoryRepository repository;

    public TransactionHistoryReadCmd(TransactionHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        transactions = repository.findAll(pageable);
    }
}
