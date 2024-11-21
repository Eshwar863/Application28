package com.example.application28.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.application28.Adapters.UsersAdapter;
import com.example.application28.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class UsersFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public UsersFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_users, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        UsersAdapter usersAdapter = new UsersAdapter(getActivity());

        viewPager.setAdapter(usersAdapter);

        new TabLayoutMediator(tabLayout,viewPager,(tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Paid Users");
                    break;
                case 1:
                    tab.setText("UnPaid Users");
                    break;
            }
        }).attach();













        return view;
    }
}