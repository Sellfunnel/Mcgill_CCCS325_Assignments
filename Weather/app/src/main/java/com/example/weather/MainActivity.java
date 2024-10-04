package com.example.weather;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.CurrentWeatherData.CurrentWeatherResponse;
import com.example.weather.CurrentWeatherData.CurrentWeatherService;
import com.example.weather.FiveDayWeatherForecast.ForecastAdapter;
import com.example.weather.FiveDayWeatherForecast.ForecastResponse;
import com.example.weather.FiveDayWeatherForecast.ForecastService;
import com.example.weather.News.NewsAdapter;
import com.example.weather.News.NewsResponse;
import com.example.weather.News.NewsService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CurrentWeatherService currentWeatherService;
    private ForecastService forecastService;
    private NewsService newsService;
    private TextView tvLocation;
    private TextView tvCurrentTemp;
    private TextView tvMinMaxTemp;
    private RecyclerView forecastRecyclerView;
    private RecyclerView newsRecyclerView;
    private ForecastAdapter forecastAdapter;
    private NewsAdapter newsAdapter;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.search_bar);
        tvLocation = findViewById(R.id.tv_location);
        tvCurrentTemp = findViewById(R.id.tv_current_temperature);
        tvMinMaxTemp = findViewById(R.id.tv_min_max_temperature);
        forecastRecyclerView = findViewById(R.id.forecast_recycler_view);
        newsRecyclerView = findViewById(R.id.news_recycler_view);

        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        forecastAdapter = new ForecastAdapter(new ArrayList<>());
        forecastRecyclerView.setAdapter(forecastAdapter);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(new ArrayList<>(), this);
        newsRecyclerView.setAdapter(newsAdapter);

        currentWeatherService = RetrofitClient.getWeatherClient().create(CurrentWeatherService.class);
        forecastService = RetrofitClient.getWeatherClient().create(ForecastService.class);
        newsService = RetrofitClient.getNewsClient().create(NewsService.class);

        fetchWeatherByCityName("Montreal");  // Default city

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = s.toString().trim();
                if (!searchText.isEmpty()) {
                    fetchWeatherByCityName(searchText);
                }
            }
        });
    }

    private void fetchWeatherByCityName(String cityName) {
        currentWeatherService.getCurrentWeather(cityName, getString(R.string.api_key), "metric").enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CurrentWeatherResponse weather = response.body();
                    tvLocation.setText(weather.getName());
                    tvCurrentTemp.setText(String.format("Current Temp: %.2f°C", weather.getMain().getTemp()));
                    tvMinMaxTemp.setText(String.format("Min: %.2f°C | Max: %.2f°C", weather.getMain().getTempMin(), weather.getMain().getTempMax()));
                    fetchFiveDayForecastByCityName(cityName);
                    fetchNewsForCity(cityName);
                } else {
                    Log.e("WeatherError", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
                Log.e("WeatherError", "Failed to fetch current weather", t);
            }
        });
    }

    private void fetchFiveDayForecastByCityName(String cityName) {
        forecastService.getFiveDayForecast(cityName, getString(R.string.api_key), "metric").enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    forecastAdapter.updateData(response.body().getList());
                } else {
                    Log.e("ForecastError", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                Log.e("ForecastError", "Failed to fetch forecast", t);
            }
        });
    }

    private void fetchNewsForCity(String cityName) {
        newsService.getTopHeadlines(
                null,
                "general",
                null,
                cityName,
                20,
                1
        ).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    newsAdapter.updateNewsList(response.body().getArticles());
                } else {
                    Log.e("NewsError", "Failed to fetch news: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("NewsError", "Network error while fetching news", t);
            }
        });
    }
}