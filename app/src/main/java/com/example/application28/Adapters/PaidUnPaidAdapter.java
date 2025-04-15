package com.example.application28.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application28.DTO.UserPaidUnPaid;
import com.example.application28.R;

import com.example.application28.viewHolders.PaidUnPaidViewHolder;

import java.util.List;

public class PaidUnPaidAdapter extends RecyclerView.Adapter<PaidUnPaidViewHolder> {

    private List<UserPaidUnPaid> userList;

    public PaidUnPaidAdapter(List<UserPaidUnPaid> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public PaidUnPaidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_items, parent, false);
        return new PaidUnPaidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaidUnPaidViewHolder holder, int position) {
        UserPaidUnPaid user = userList.get(position);
        holder.Name.setText(user.getName());
        holder.phno.setText(user.getPhoneNumber());
        holder.Userid.setText("ID: " + user.getId());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
