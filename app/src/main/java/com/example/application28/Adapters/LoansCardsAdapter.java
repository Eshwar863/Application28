package com.example.application28.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.application28.DTO.Loans;
import com.example.application28.R;
import com.example.application28.viewHolders.HistoryViewHolder;
import com.example.application28.viewHolders.LoansCardsViewHolder;

import java.util.List;

public class LoansCardsAdapter extends RecyclerView.Adapter<LoansCardsViewHolder> {
    Context context;

    List<Loans> loans;

    public LoansCardsAdapter(Context context, List<Loans> loans) {
        this.context = context;
        this.loans = loans;
    }

    @NonNull
    @Override
    public LoansCardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoansCardsViewHolder(LayoutInflater.from(context).inflate(R.layout.loan_card_view,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull LoansCardsViewHolder holder, int position) {
        Loans loan = loans.get(position);
        holder.tvLoanId.setText(loan.getLoanId().toString());
        holder.tvLoanAmount.setText(loan.getLoanAmount().toString());
        holder.tvInterest.setText(loan.getInterestAmount().toString());
        holder.tvLoanDate.setText(loan.getLoanDate().toString());

    }

    @Override
    public int getItemCount() {
        return loans.size();
    }
}
