package com.example.application28.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.application28.AccountDetails;
import com.example.application28.Api.ApiService;
import com.example.application28.DTO.Amounts;
import com.example.application28.LoginActivity;
import com.example.application28.R;
import com.example.application28.Register;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    ImageButton AccDes;
    ApiService apiService;
    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:8080/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        apiService = retrofit.create(ApiService.class);

         View view  = inflater.inflate(R.layout.fragment_home, container, false);
         AccDes = view.findViewById(R.id.accountButton);
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
//    public void getByDate(){
//        String tokenexp = "Token expired";
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFc2h3YXIiLCJpYXQiOjE3Mjk3NjI4MjMsImV4cCI6MTcyOTc2NjQyM30.kJmHGL3YKo6aPQWzTaaI4HrQWe1iWrrlGEaWb8GmmEY";
//        Call<Amounts> call=apiService.GetByDate("Bearer " + token);
//        call.enqueue(new Callback<Amounts>() {
//            @Override
//            public void onResponse(Call<Amounts> call, Response<Amounts> response) {
//                if(response.isSuccessful() && response.body()!=null){
//
//                }
//                else if(response.isSuccessful() && response.message().equals(tokenexp)){
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    startActivity(intent);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Amounts> call, Throwable t) {
//
//            }
//        });
//    }


}