package com.example.application28.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application28.R;

public class LoansCardsViewHolder extends RecyclerView.ViewHolder{

    public TextView tvLoanId,tvLoanDate,tvLoanAmount,tvInterest;

    public LoansCardsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvLoanId = itemView.findViewById((R.id.tvLoanId));
        tvLoanDate = itemView.findViewById((R.id.tvLoanDate));
        tvLoanAmount = itemView.findViewById((R.id.tvLoanAmount));
        tvInterest = itemView.findViewById((R.id.tvInterest));
    }
}
