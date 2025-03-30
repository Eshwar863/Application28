package com.example.application28.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application28.AccountDetails;
import com.example.application28.Api.ApiService;
import com.example.application28.DTO.Amounts;
import com.example.application28.LoginActivity;
import com.example.application28.R;
import com.example.application28.Register;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.NumberFormat;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private ImageButton AccDes;
    private TextView totalamount,InterestAmount,cards,UserPaid,Date;
    ApiService apiService;
    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);

        View view  = inflater.inflate(R.layout.fragment_home, container, false);
         AccDes = view.findViewById(R.id.accountButton);
        totalamount = view.findViewById(R.id.textView2);
        InterestAmount= view.findViewById(R.id.textViewInterest);
        cards= view.findViewById(R.id.textViewCards);
        UserPaid= view.findViewById(R.id.textViewUsersPaid);
        Date = view.findViewById(R.id.DateView);
        //getByDate();
        totalamount.setText(formatCurrency((long) 10100000));
         AccDes.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                Toast.makeText(getActivity(), "Account Details", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), AccountDetails.class);
                startActivity(intent);
             }
         });
        return view;
    }
    public void getByDate(){
        String tokenexp = "Token expired";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFc2h3YXIiLCJpYXQiOjE3NDMzNTA2NDksImV4cCI6MTc0MzM1NDI0OX0.g3w9enpuolE_61PkKwBWOsrBZc2i-ydD4st43QPk4UQ";
        Call<Amounts> call=apiService.GetByDate("Bearer " + token);
        call.enqueue(new Callback<Amounts>() {
            @Override
            public void onResponse(Call<Amounts> call, Response<Amounts> response) {
                if(response.isSuccessful() && response.body()!=null){
                    Amounts amounts = response.body();
                    totalamount.setText(formatCurrency(amounts.getTotalamounts()));

//                    nameEditText.setText(user.getUserName());
//                    emailEditText.setText(user.getEmail());
//                    dobEditText.setText(user.getDOB());
                }
                else if(response.isSuccessful() && response.message().equals(tokenexp)){
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Amounts> call, Throwable t) {

            }
        });
    }

private static String formatCurrency(Long amount) {
    if (amount == null) return "₹0.00";

    // Convert cents to dollars
    double value = amount / 100.0;

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
    formatter.setMaximumFractionDigits(2);
    formatter.setMinimumFractionDigits(2);

    return formatter.format(value);
}



}