package com.example.application28.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application28.DTO.Cards;
import com.example.application28.R;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder>  {

    private List<Cards> cardsList;


    public CardsAdapter(List<Cards> cardsList) {
        this.cardsList=cardsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_cards_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cards card = cardsList.get(position);
        holder.txtName.setText(card.getcName());
        holder.txtType.setText(card.getcType());
        holder.txtStartDate.setText(card.getFormattedStartDate().toString());
        holder.txtExpireDate.setText(card.getFormattedExpireDate().toString());
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtType, txtStartDate, txtExpireDate;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtType = itemView.findViewById(R.id.txtType);
            txtStartDate = itemView.findViewById(R.id.txtStartDate);
            txtExpireDate = itemView.findViewById(R.id.txtExpireDate);
        }
    }

}