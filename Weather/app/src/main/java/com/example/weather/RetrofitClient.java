package com.example.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofitWeather = null;
    private static Retrofit retrofitNews = null;
    private static final String BASE_URL_WEATHER = "https://api.openweathermap.org/data/2.5/";
    private static final String BASE_URL_NEWS = "https://newsapi.org/v2/";

    public static Retrofit getWeatherClient() {
        if (retrofitWeather == null) {
            retrofitWeather = new Retrofit.Builder()
                    .baseUrl(BASE_URL_WEATHER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitWeather;
    }

    public static Retrofit getNewsClient() {
        if (retrofitNews == null) {
            retrofitNews = new Retrofit.Builder()
                    .baseUrl(BASE_URL_NEWS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitNews;
    }
}
