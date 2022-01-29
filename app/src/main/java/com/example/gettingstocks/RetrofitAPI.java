package com.example.gettingstocks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<com.example.gettingstocks.NewsModal> getAllNews(@Url String url);

    @GET
    Call<com.example.gettingstocks.NewsModal> getNewsByCategory(@Url String url);
}
