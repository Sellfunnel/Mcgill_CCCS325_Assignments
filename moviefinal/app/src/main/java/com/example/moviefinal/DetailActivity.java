package com.example.moviefinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.movie_image);
        TextView titleTextView = findViewById(R.id.movie_title);
        TextView directorTextView = findViewById(R.id.movie_director);
        TextView starsTextView = findViewById(R.id.movie_stars);
        TextView descriptionTextView = findViewById(R.id.movie_description);
        TextView priceTextView = findViewById(R.id.movie_price);

        // Get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int imageResId = intent.getIntExtra("image", 0);
        String description = intent.getStringExtra("description");
        String director = intent.getStringExtra("director");
        String stars = intent.getStringExtra("stars");
        double price = intent.getDoubleExtra("price", 0);

        // Set data to views
        imageView.setImageResource(imageResId);
        titleTextView.setText(title);
        directorTextView.setText("Director: " + director);
        starsTextView.setText("Stars: " + stars);
        descriptionTextView.setText(description);
        priceTextView.setText(String.format("$%.2f", price));
    }
}