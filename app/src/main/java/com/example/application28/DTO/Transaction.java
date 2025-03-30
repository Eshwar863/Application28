package com.example.application28.DTO;

import java.time.LocalDateTime;

public class Transaction {
    private Long tid;
    private Long amount;
    private String type;
    private LocalDateTime transactionTime;
    private String transDescription;

    public Transaction(Long tid, Long amount, String type, LocalDateTime transactionTime, String transDescription) {
        this.tid = tid;
        this.amount = amount;
        this.type = type;
        this.transactionTime = transactionTime;
        this.transDescription = transDescription;
    }

    public Long getTid() { return tid; }
    public Long getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getTransactionTime() { return transactionTime; }
    public String getTransDescription() { return transDescription; }
}
