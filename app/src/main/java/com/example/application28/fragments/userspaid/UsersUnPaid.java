package com.example.application28.fragments.userspaid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.application28.R;


public class UsersUnPaid extends Fragment {

    public UsersUnPaid() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users_un_paid, container, false);
        return  view;
    }
}