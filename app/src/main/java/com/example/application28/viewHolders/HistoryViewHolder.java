package com.example.application28.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application28.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageViewloans;
    public ImageView imageViewTypeTotals;
    public ImageView imageViewCardsInterestUpdated;
    public ImageView imageViewTypeCards;
    public TextView transactionName;
    public TextView TransactionDes;
    public TextView TransactionAmount;
    public TextView Transactiondate;
    public HistoryViewHolder(@NonNull View itemView) {

        super(itemView);
        transactionName = itemView.findViewById((R.id.tvTransactionName));
        TransactionDes = itemView.findViewById((R.id.tvDescription));
        TransactionAmount  = itemView.findViewById((R.id.tvAmount));
        Transactiondate = itemView.findViewById((R.id.tvTransactionTime));
        imageViewloans = itemView.findViewById((R.id.ivTransactionTypeLoan));
        imageViewTypeCards = itemView.findViewById((R.id.ivTransactionTypeCards));
        imageViewTypeTotals = itemView.findViewById((R.id.ivTransactionTypeTotals));
        imageViewCardsInterestUpdated = itemView.findViewById((R.id.ivTransactionTypeInterestUpdated));

    }
}
