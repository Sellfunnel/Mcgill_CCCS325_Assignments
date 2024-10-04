package com.example.weather.FiveDayWeatherForecast;

import java.util.List;

public class ForecastResponse {
    private String cod;
    private double message;
    private int cnt;
    private List<ForecastItem> list;

    public String getCod() { return cod; }
    public void setCod(String cod) { this.cod = cod; }
    public double getMessage() { return message; }
    public void setMessage(double message) { this.message = message; }
    public int getCnt() { return cnt; }
    public void setCnt(int cnt) { this.cnt = cnt; }
    public List<ForecastItem> getList() { return list; }
    public void setList(List<ForecastItem> list) { this.list = list; }
}

