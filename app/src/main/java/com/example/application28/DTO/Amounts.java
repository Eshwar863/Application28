package com.example.application28.DTO;

public class Amounts {
    private String date;
    private Long Totalamounts;
    private Long totalInterestAmount;
    private Long UserPaidByAmount;
    private Long CardsAmount;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotalamounts() {
        return Totalamounts;
    }

    public void setTotalamounts(Long totalamounts) {
        Totalamounts = totalamounts;
    }

    public Long getTotalInterestAmount() {
        return totalInterestAmount;
    }

    public void setTotalInterestAmount(Long totalInterestAmount) {
        this.totalInterestAmount = totalInterestAmount;
    }

    public Long getUserPaidByAmount() {
        return UserPaidByAmount;
    }

    public void setUserPaidByAmount(Long userPaidByAmount) {
        UserPaidByAmount = userPaidByAmount;
    }

    public Long getCardsAmount() {
        return CardsAmount;
    }

    public void setCardsAmount(Long cardsAmount) {
        CardsAmount = cardsAmount;
    }

    public Amounts(String date, Long totalamounts, Long totalInterestAmount, Long userPaidByAmount, Long cardsAmount) {
        this.date = date;
        Totalamounts = totalamounts;
        this.totalInterestAmount = totalInterestAmount;
        UserPaidByAmount = userPaidByAmount;
        CardsAmount = cardsAmount;
    }


}
