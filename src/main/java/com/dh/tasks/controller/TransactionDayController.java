package com.dh.tasks.controller;

import com.dh.tasks.api.request.TransactionDayRequest;
import com.dh.tasks.command.TransactionDayInsertCmd;
import com.dh.tasks.command.TransactionDayReadCmd;
import com.dh.tasks.command.core.CommandFactory;
import com.dh.tasks.model.domain.TransactionDay;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction-day")
@RequiredArgsConstructor
public class TransactionDayController {

    private final CommandFactory commandFactory;

    @GetMapping
    public ResponseEntity<Page<TransactionDay>> getTransactionDays(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        TransactionDayReadCmd readCmd = commandFactory.createInstance(TransactionDayReadCmd.class);
        readCmd.setPageable(PageRequest.of(page, size));
        readCmd.execute();
        return ResponseEntity.ok(readCmd.getTransactions());
    }

    @PostMapping
    public ResponseEntity<TransactionDay> insertTransactionDay(@RequestBody TransactionDayRequest transaction) {
        TransactionDayInsertCmd insertCmd = commandFactory.createInstance(TransactionDayInsertCmd.class);
        insertCmd.setTransactionDayRequest(transaction);
        insertCmd.execute();

        return ResponseEntity.ok(insertCmd.getTransactionDay());
    }
}
