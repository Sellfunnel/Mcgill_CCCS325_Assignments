package com.example.weather.CurrentWeatherData;

import java.util.List;

public class CurrentWeatherResponse {
    private Coordinate coord;
    private List<Weather> weather;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private String name;


    public Coordinate getCoord() { return coord; }
    public void setCoord(Coordinate coord) { this.coord = coord; }
    public List<Weather> getWeather() { return weather; }
    public void setWeather(List<Weather> weather) { this.weather = weather; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }
    public int getVisibility() { return visibility; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    public Clouds getClouds() { return clouds; }
    public void setClouds(Clouds clouds) { this.clouds = clouds; }
    public int getDt() { return dt; }
    public void setDt(int dt) { this.dt = dt; }
    public Sys getSys() { return sys; }
    public void setSys(Sys sys) { this.sys = sys; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

