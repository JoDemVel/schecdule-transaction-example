package com.dh.tasks.controller;

import com.dh.tasks.command.TransactionHistoryReadCmd;
import com.dh.tasks.command.core.CommandFactory;
import com.dh.tasks.model.domain.TransactionHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction-history")
@RequiredArgsConstructor
public class TransactionHistoryController {

    private final CommandFactory commandFactory;

    @GetMapping
    public ResponseEntity<Page<TransactionHistory>> getTransactionHistories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        TransactionHistoryReadCmd readCmd = commandFactory.createInstance(TransactionHistoryReadCmd.class);
        readCmd.setPageable(pageable);
        readCmd.execute();

        return ResponseEntity.ok(readCmd.getTransactions());
    }
}
