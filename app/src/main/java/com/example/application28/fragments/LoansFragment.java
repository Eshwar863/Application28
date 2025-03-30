package com.example.application28.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.application28.Activity.LoansActivity;
import com.example.application28.R;

public class LoansFragment extends Fragment {

    private static final String TAG = "LoansFragment"; // Tag for logging
    private TextView tvViewAll;

    public LoansFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loans, container, false);

        // Initialize the "View All" TextView
        tvViewAll = view.findViewById(R.id.tvViewAll);

        tvViewAll.setOnClickListener(v -> {
            Context context = getContext();
            if (context != null) {
                Intent intent = new Intent(context, LoansActivity.class);
                startActivity(intent);
            } else {
                Log.e(TAG, "Context is null - cannot start activity");
            }
        });

        return view;
    }
}