package com.example.application28.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.application28.R;


public class HistoryFragment extends Fragment {



    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        // Find ImageView
        ImageView loadingGif = view.findViewById(R.id.loadingGif);

        // Show loading animation
        loadingGif.setVisibility(View.VISIBLE);

        // Load WebP or GIF using Glide
        Glide.with(this)
                .load(R.drawable.gp) // Make sure "gp" is in the `res/drawable/` folder
                .into(loadingGif);

        // Simulating data loading (replace with real data loading logic)
        new android.os.Handler().postDelayed(() -> {
            // Hide loading animation after 3 seconds (simulate data load)
            loadingGif.setVisibility(View.GONE);
        }, 3000);

        return view;
    }


}