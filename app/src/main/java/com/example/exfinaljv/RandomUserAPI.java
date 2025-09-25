package com.example.exfinaljv;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUserAPI {
    @GET("api/")
    Call<APIResponse> getUsers(@Query("results") int results);
}