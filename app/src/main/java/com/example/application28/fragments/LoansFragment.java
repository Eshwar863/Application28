package com.example.application28.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.application28.Adapters.LoansCardsAdapter;
import com.example.application28.DTO.Loans;
import com.example.application28.LoginActivity;
import com.example.application28.R;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

public class LoansFragment extends Fragment {

    private static final String TAG = "LoansFragment"; // Tag for logging
    private TextView tvViewAll, tvNoLoansFound;

    public LoansFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loans, container, false);
        tvViewAll = view.findViewById(R.id.tvViewAll);
        tvNoLoansFound = view.findViewById(R.id.tvNoLoansFound);
        RecyclerView recyclerView = view.findViewById(R.id.recentLoansRecyclerViewLoansCards);
        Context context = getContext();

        if (context != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            List<Loans> dummyLoans = new ArrayList<>();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dummyLoans.add(new Loans(1001L, 5022222000L, 5000L, LocalDateTime.now().minusDays(2)));
                dummyLoans.add(new Loans(1002L, 75000L, 7500L, LocalDateTime.now().minusDays(10)));
                dummyLoans.add(new Loans(1003L, 30036555500L, 3000L, LocalDateTime.now().minusDays(20)));
            }

            if (dummyLoans.isEmpty()) {
                tvNoLoansFound.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            } else {
                tvNoLoansFound.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                LoansCardsAdapter adapter = new LoansCardsAdapter(context, dummyLoans);
                recyclerView.setAdapter(adapter);
            }

            tvViewAll.setOnClickListener(v -> {
                Intent intent = new Intent(context, LoginActivity.class); // Or LoansActivity if needed
                startActivity(intent);
            });

        } else {
            Log.e(TAG, "Context is null - cannot set up RecyclerView");
        }

        return view;
    }
}