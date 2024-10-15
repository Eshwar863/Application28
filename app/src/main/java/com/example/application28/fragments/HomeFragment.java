package com.example.application28.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.application28.R;
import com.example.application28.Register;

public class HomeFragment extends Fragment {

    ImageButton AccDes;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view  = inflater.inflate(R.layout.fragment_home, container, false);
         AccDes = view.findViewById(R.id.accountButton);
         AccDes.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // Use getActivity() or getContext() for the correct context
                 Toast.makeText(getActivity(), "Account Details", Toast.LENGTH_SHORT).show();
             }
         });
        return view;
    }
}