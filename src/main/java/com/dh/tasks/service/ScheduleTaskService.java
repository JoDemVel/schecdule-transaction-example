package com.dh.tasks.service;

import com.dh.tasks.command.TransactionDayReadCmd;
import com.dh.tasks.command.TransactionHistoryInsertCmd;
import com.dh.tasks.command.core.CommandFactory;
import com.dh.tasks.model.domain.TransactionDay;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleTaskService {

    private final CommandFactory commandFactory;

    @Scheduled(cron = "0 */10 * * * *")
    public void fillTransactionHistory() {
        TransactionDayReadCmd readCmd = commandFactory.createInstance(TransactionDayReadCmd.class);
        readCmd.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
        readCmd.execute();

        List<TransactionDay> transactions = readCmd.getTransactions().getContent();
        if (transactions.isEmpty()) return;

        TransactionHistoryInsertCmd insertCmd = commandFactory.createInstance(TransactionHistoryInsertCmd.class);
        insertCmd.setTransactions(transactions);
        insertCmd.execute();
    }
}
