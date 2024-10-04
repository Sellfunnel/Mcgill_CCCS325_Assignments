package com.example.weather.FiveDayWeatherForecast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.weather.R;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<ForecastItem> forecastItems;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDate;
        public TextView textViewTemp;
        public ImageView imageViewWeather;

        public ForecastViewHolder(View v) {
            super(v);
            textViewDate = v.findViewById(R.id.date);
            textViewTemp = v.findViewById(R.id.temperature);
            imageViewWeather = v.findViewById(R.id.weather_icon);
        }
    }

    public ForecastAdapter(List<ForecastItem> forecastItems) {
        this.forecastItems = forecastItems;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item, parent, false);
        return new ForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        ForecastItem item = forecastItems.get(position);
        holder.textViewDate.setText(item.getDtTxt());
        holder.textViewTemp.setText(String.format("%s°C", item.getMain().getTemp()));

        Glide.with(holder.imageViewWeather.getContext())
                .load("http://openweathermap.org/img/wn/" + item.getWeather().get(0).getIcon() + "@2x.png")
                .placeholder(R.drawable.ic_weather)
                .into(holder.imageViewWeather);
    }

    @Override
    public int getItemCount() {
        return forecastItems.size();
    }

    public void updateData(List<ForecastItem> newForecastItems) {
        forecastItems = newForecastItems;
        notifyDataSetChanged();
    }
}
