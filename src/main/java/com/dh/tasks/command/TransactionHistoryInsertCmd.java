package com.dh.tasks.command;

import com.dh.tasks.command.core.Command;
import com.dh.tasks.command.core.CommandExecute;
import com.dh.tasks.command.core.CommandFactory;
import com.dh.tasks.model.builder.TransactionHistoryBuilder;
import com.dh.tasks.model.domain.TransactionDay;
import com.dh.tasks.model.domain.TransactionHistory;
import com.dh.tasks.model.repository.TransactionHistoryRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@CommandExecute
public class TransactionHistoryInsertCmd implements Command {

    @Setter
    private List<TransactionDay> transactions;

    @Getter
    private boolean success = false;

    private final CommandFactory commandFactory;

    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryInsertCmd(CommandFactory commandFactory, TransactionHistoryRepository transactionHistoryRepository) {
        this.commandFactory = commandFactory;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Override
    public void execute(){
        List<TransactionHistory> historyList = transactions.stream()
                .map(TransactionHistoryBuilder::getInstance)
                .collect(Collectors.toList());

        transactionHistoryRepository.saveAll(historyList);
        deleteAllTransactionDay();
        success = true;
    }

    private void deleteAllTransactionDay() {
        TransactionDayClearCmd command = commandFactory.createInstance(TransactionDayClearCmd.class);
        command.execute();
    }
}
