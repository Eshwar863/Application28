package com.example.application28;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.application28.fragments.CardsFragment;
import com.example.application28.fragments.HistoryFragment;
import com.example.application28.fragments.HomeFragment;
import com.example.application28.fragments.LoansFragment;
import com.example.application28.fragments.UsersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
//        preferences.getString("Name","UserName");

        Button button = findViewById(R.id.button2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("jwtToken", null);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Set HomeFragment as the default fragment when the activity starts
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }

        // Set listener to handle fragment changes based on selected menu item
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();
            if (itemId == R.id.homeFragment) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.historyFragment) {
                selectedFragment = new HistoryFragment();
            } else if (itemId == R.id.loanFragment) {
                selectedFragment = new LoansFragment();
            } else if (itemId == R.id.cardsFragment) {
                selectedFragment = new CardsFragment();
            } else if (itemId == R.id.usersFragment) {
                selectedFragment = new UsersFragment();
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }
            return true;
        });

    }

    // Helper method to load a fragment
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }



}