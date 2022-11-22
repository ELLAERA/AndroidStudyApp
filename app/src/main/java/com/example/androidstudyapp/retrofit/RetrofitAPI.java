package com.example.androidstudyapp.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @GET("15040824/v1/uddi:b2f83d90-2d35-455c-9bd1-de5492f00a46")
    Call<RetrofitDTO> getNaturalGasData(@Query("page") int page, @Query("perPage") int perPage, @Query("serviceKey") String serviceKey);
}