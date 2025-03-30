package com.example.application28.Adapters;


import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application28.DTO.Transaction;
import com.example.application28.R;
import com.example.application28.viewHolders.HistoryViewHolder;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
   Context context;
   List<Transaction> transactionList;

    public HistoryAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.history,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);

        holder.TransactionAmount.setText("₹"+ transaction.getAmount());
        holder.transactionName.setText(transaction.getType());

        holder.imageViewloans.setVisibility(View.GONE);
        holder.imageViewTypeTotals.setVisibility(View.GONE);
        holder.imageViewCardsInterestUpdated.setVisibility(View.GONE);
        holder.imageViewTypeCards.setVisibility(View.GONE);

        if (transaction.getType().equals("Loans")) {
            holder.imageViewloans.setVisibility(View.VISIBLE);
        } else if (transaction.getType().equals("Totals")) {
            holder.imageViewTypeTotals.setVisibility(View.VISIBLE);
        } else if (transaction.getType().equals("InterestUpdated")) {
            holder.imageViewCardsInterestUpdated.setVisibility(View.VISIBLE);
        } else if (transaction.getType().equals("Cards")) {
            holder.imageViewTypeCards.setVisibility(View.VISIBLE);
        }

        DateTimeFormatter formatter = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.Transactiondate.setText(transaction.getTransactionTime().format(formatter));
        }
        holder.TransactionDes.setText(transaction.getTransDescription());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }
}
