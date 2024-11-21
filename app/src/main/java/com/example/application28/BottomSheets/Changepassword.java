package com.example.application28.BottomSheets;


import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application28.Api.ApiService;
import com.example.application28.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Changepassword extends BottomSheetDialogFragment {
    static final String TAG = "hello"; // Log tag
    private ApiService apiService;
    Button submitButton,validate;
    private EditText reenterPasswordEditText,passwordEditText ,currentpassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changepasswordbsd, container, false);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://finalssecurity1-v1-0.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);
        currentpassword = view.findViewById(R.id.currentPasswordEditText2);
         validate = view.findViewById(R.id.validate);
        passwordEditText = view.findViewById(R.id.enterPasswordEditText);
        reenterPasswordEditText = view.findViewById(R.id.reenterpasswordEditText);
        submitButton = view.findViewById(R.id.submitButton);


        validate.setOnClickListener(v -> {
            Integer userId = 1;
            String currentPass = currentpassword.getText().toString().trim();

            if ("1".equals(currentPass)) {
                passwordEditText.setVisibility(View.VISIBLE);
                reenterPasswordEditText.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                currentpassword.setVisibility(View.GONE);
                validate.setVisibility(View.GONE);

            } else {
                Toast.makeText(getContext(), "Invalid current password", Toast.LENGTH_SHORT).show();
            }
        });

        submitButton.setOnClickListener(v -> {
            String password = passwordEditText.getText().toString().trim();
            String reenterPassword = reenterPasswordEditText.getText().toString().trim();

            if (password.isEmpty() || password.length() < 6) {
                Toast.makeText(getContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.equals(reenterPassword)) {
                Log.d(TAG, "Passwords match, calling forgotpass()");

            } else {
                Log.d(TAG, "Passwords do not match.");
                Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });






        submitButton.setOnClickListener(v -> {
            String password = passwordEditText.getText().toString();
            String reenterPassword = reenterPasswordEditText.getText().toString();

            Log.d(TAG, "Submit button clicked. Password: " + password + ", Re-enter Password: " + reenterPassword);

            if (password.equals(reenterPassword)) {
                Log.d(TAG, "Passwords match, calling forgotpass()");
            } else {
                Log.d(TAG, "Passwords do not match.");
                Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {

            ViewGroup bottomSheet = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                BottomSheetBehavior<ViewGroup> behavior = BottomSheetBehavior.from(bottomSheet);
                bottomSheet.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }
    }

}

