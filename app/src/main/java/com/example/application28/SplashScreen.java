package com.example.application28;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {
    //public static final String BASE_URL = "http://10.0.2.2:8000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    SharedPreferences pref = getSharedPreferences("Login", MODE_PRIVATE);
                    String Token = pref.getString("jwtToken", null);
                    //pref.getString("Name","UserName");
                    if (Token == null) {
                        Intent Login = new Intent(SplashScreen.this, LoginActivity.class);
                        startActivity(Login);
                    } else {
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Log the error to logcat
                }
                finish(); // Always call finish
            }
        }, 2000);

    }
}