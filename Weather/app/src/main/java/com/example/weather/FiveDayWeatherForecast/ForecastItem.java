package com.example.weather.FiveDayWeatherForecast;

import com.example.weather.CurrentWeatherData.Clouds;
import com.example.weather.CurrentWeatherData.Main;
import com.example.weather.CurrentWeatherData.Weather;
import com.example.weather.CurrentWeatherData.Wind;

import java.util.List;

public class ForecastItem {
    private long dt;
    private Main main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private String dt_txt;
    private int weatherIcon; // Add this to store weather icon resource IDs

    public long getDt() { return dt; }
    public void setDt(long dt) { this.dt = dt; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }
    public List<Weather> getWeather() { return weather; }
    public void setWeather(List<Weather> weather) { this.weather = weather; }
    public Clouds getClouds() { return clouds; }
    public void setClouds(Clouds clouds) { this.clouds = clouds; }
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    public String getDtTxt() { return dt_txt; }
    public void setDtTxt(String dt_txt) { this.dt_txt = dt_txt; }
    public int getWeatherIcon() { return weatherIcon; }  // Getter for weather icon
    public void setWeatherIcon(int weatherIcon) { this.weatherIcon = weatherIcon; }  // Setter for weather icon
}
