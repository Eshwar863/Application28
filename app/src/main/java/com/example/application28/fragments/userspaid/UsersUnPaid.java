package com.example.application28.fragments.userspaid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.application28.Adapters.PaidUnPaidAdapter;

import com.example.application28.DTO.UserPaidUnPaid;

import com.example.application28.R;

import java.util.ArrayList;
import java.util.List;

public class UsersUnPaid extends Fragment {

    public UsersUnPaid() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_un_paid, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvusersunpaid);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<UserPaidUnPaid> dummyUsers = new ArrayList<>();
        dummyUsers.add(new UserPaidUnPaid("Rahul", "rahul@example.com","1"));
        dummyUsers.add(new UserPaidUnPaid("Don", "priya@example.com","2"));
        dummyUsers.add(new UserPaidUnPaid("VCR", "rahul@example.com","3"));
        dummyUsers.add(new UserPaidUnPaid("Dr", "priya@example.com","4"));
        dummyUsers.add(new UserPaidUnPaid("Mo", "rahul@example.com","5"));
        dummyUsers.add(new UserPaidUnPaid("Tiger", "priya@example.com","6"));


        PaidUnPaidAdapter adapter = new PaidUnPaidAdapter(dummyUsers);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
