package com.example.weather.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsService {
    @Headers("X-Api-Key: 66f5a17895404715b7d04a6466089b9b")
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(
            @Query("country") String country,
            @Query("category") String category,
            @Query("sources") String sources,
            @Query("q") String query,
            @Query("pageSize") int pageSize,
            @Query("page") int page
    );
}
