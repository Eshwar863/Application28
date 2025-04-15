package com.example.application28.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.application28.Adapters.HistoryAdapter;
import com.example.application28.DTO.Transaction;
import com.example.application28.R;
import com.google.android.material.button.MaterialButton;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private TextView tvBalance;
    private MaterialButton btnToggle;
    private boolean isBalanceVisible = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        tvBalance = view.findViewById(R.id.tvBalance);
        btnToggle = view.findViewById(R.id.btnToggleVisibility);
        RecyclerView recyclerView = view.findViewById(R.id.rvHistory);

        // RecyclerView setup
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create dummy transaction data for testing
        List<Transaction> transactions = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            transactions.add(new Transaction(1L, 5000L, "Loans", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3000L, "Cards", LocalDateTime.now(), "Credit Card Bill"));

            transactions.add(new Transaction(1L, 5000L, "Totals", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3000L, "InterestUpdated", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(1L, 5000L, "Totals", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3000L, "InterestUpdated", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(1L, 5000L, "Totals", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(1L, 5000L, "Loans", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3000L, "Cards", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(2L, 3000L, "InterestUpdated", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(1L, 5000L, "Loans", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(1L, 5000L, "Loans", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3000L, "Cards", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(2L, 3000L, "Cards", LocalDateTime.now(), "Credit Card Bill"));

            transactions.add(new Transaction(1L, 5200L, "Totals", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(1L, 5000L, "Loans", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3000L, "Cards", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(2L, 3100L, "InterestUpdated", LocalDateTime.now(), "Credit Card Bill"));
            transactions.add(new Transaction(1L, 4800L, "Totals", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 2900L, "InterestUpdated", LocalDateTime.now(), "Credit Card Bill"));

            transactions.add(new Transaction(1L, 5300L, "Loans", LocalDateTime.now(), "Loan Payment"));
            transactions.add(new Transaction(2L, 3200L, "Cards", LocalDateTime.now(), "Credit Card Bill"));


        }

        // Set adapter
        HistoryAdapter adapter = new HistoryAdapter(getContext(), transactions);
        recyclerView.setAdapter(adapter);

        // Toggle balance visibility
        btnToggle.setOnClickListener(v -> {
            isBalanceVisible = !isBalanceVisible;
            if (isBalanceVisible) {
                tvBalance.setText("₹9,763.58");
                btnToggle.setText("Hide");
            } else {
                tvBalance.setText("********");
                btnToggle.setText("Show");
            }
        });








}
    private void updateBalanceDisplay() {
        if (isBalanceVisible) {
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
            String formattedAmount = "₹" + nf.format(Double.parseDouble(tvBalance.getText().toString().replace("₹", "").replace(",", "")));
            tvBalance.setText(formattedAmount);
        } else {
            tvBalance.setText("********");
        }
    }
}