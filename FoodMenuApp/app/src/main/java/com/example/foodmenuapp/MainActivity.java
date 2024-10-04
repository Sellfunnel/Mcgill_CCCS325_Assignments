package com.example.foodmenuapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAppetizers = findViewById(R.id.btnAppetizers);
        Button btnMeals = findViewById(R.id.btnMeals);
        Button btnDrinks = findViewById(R.id.btnDrinks);
        Button btnDesserts = findViewById(R.id.btnDesserts);

        btnAppetizers.setOnClickListener(v -> openFoodList("Appetizers"));
        btnMeals.setOnClickListener(v -> openFoodList("Meals"));
        btnDrinks.setOnClickListener(v -> openFoodList("Drinks"));
        btnDesserts.setOnClickListener(v -> openFoodList("Desserts"));
    }

    private void openFoodList(String category) {
        Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}