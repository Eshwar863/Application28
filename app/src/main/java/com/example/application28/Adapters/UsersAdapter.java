package com.example.application28.Adapters;

import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.application28.fragments.userspaid.UsersPaid;
import com.example.application28.fragments.userspaid.UsersUnPaid;

public class UsersAdapter extends FragmentStateAdapter {

    public UsersAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new UsersPaid();
            case 1:
                return new UsersUnPaid();
            default:
                return new UsersUnPaid();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
