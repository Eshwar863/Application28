package com.example.application28.fragments;

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

        // Set a click listener on the "View All" TextView
        tvViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "View All clicked"); // Log the click event

                // Check if the activity is not null
                if (getActivity() != null) {
                    Log.d(TAG, "Activity context is available");
                    try {
                        // Create an intent to launch LoansActivity
                        Intent intent = new Intent(getActivity(), LoansActivity.class);
                        startActivity(intent);
                        Log.d(TAG, "LoansActivity started successfully");
                    } catch (Exception e) {
                        Log.e(TAG, "Error starting LoansActivity: " + e.getMessage(), e);
                    }
                } else {
                    Log.e(TAG, "Activity context is null");
                }
            }
        });

        return view;
    }
}