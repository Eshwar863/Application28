package com.example.application28;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application28.BottomSheets.Changepassword;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class AccountDetails extends AppCompatActivity {
    private TextView changepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_details);
        changepassword =findViewById(R.id.changePasswordTextView);

        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changepassword passwordBottomSheetDialog = new Changepassword();
                passwordBottomSheetDialog.show(getSupportFragmentManager(), "PasswordBottomSheetDialog");
            }
        });


    }
    public void onProfileSectionClick(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}