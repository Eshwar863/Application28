package com.example.application28;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        EditText editTextPhone =  findViewById(R.id.editTextPhone);
        EditText editpass =  findViewById(R.id.editTextPassword);
        Button RegisterBT = findViewById(R.id.buttonRegister);
        Button LoginBT = findViewById(R.id.buttonLogin);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("Login",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("jwtToken","hello");
                        editor.apply();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        RegisterBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, com.example.application28.Register.class);
                startActivity(intent);

            }
        });
        LoginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences preferences = getSharedPreferences("Login",MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("jwtToken","hello");
//                editor.apply();
//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//                //finish();


            }
        });
    }

}


//SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
//SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString("jwtToken", response); // Assume response contains JWT
//                    editor.apply();
//startActivity(new Intent(LoginActivity.this, MainActivity.class));
//