package com.example.application28.DTO;

import java.time.LocalDateTime;

public class Loans {

    private Long loanId;
    private Long loanAmount ;
    private Long interestAmount;
    private LocalDateTime loanDate;

    public Loans(Long loanId, Long loanAmount, Long interestAmount, LocalDateTime loanDate) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.interestAmount = interestAmount;
        this.loanDate = loanDate;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Long interestAmount) {
        this.interestAmount = interestAmount;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
}
