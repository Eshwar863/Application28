package com.example.application28.Api;

import com.example.application28.DTO.Amounts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {
@GET("api/ByDate")
Call<Amounts> GetByDate(@Header("Authorization") String token);
}
