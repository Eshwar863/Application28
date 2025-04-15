package com.example.application28.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application28.R;

public class PaidUnPaidViewHolder extends RecyclerView.ViewHolder {
   public TextView Name,phno,Userid;
    public PaidUnPaidViewHolder(@NonNull View itemView) {
        super(itemView);
        Name = itemView.findViewById((R.id.tvUserName));
        phno = itemView.findViewById((R.id.tvUserPhno));
        Userid = itemView.findViewById((R.id.tvUserId));
    }
}
