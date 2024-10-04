package com.example.foodmenuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {
    private ListView foodListView;
    private TextView totalPriceText;
    private Button seeCartButton;
    private List<FoodItem> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        foodListView = findViewById(R.id.foodListView);
        totalPriceText = findViewById(R.id.totalPriceText);
        seeCartButton = findViewById(R.id.seeCartButton);
        String category = getIntent().getStringExtra("category");
        initializeData(category);

        ArrayAdapter<FoodItem> adapter = new ArrayAdapter<FoodItem>(this, android.R.layout.simple_list_item_1, foodItems) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView item = (TextView) super.getView(position, convertView, parent);
                FoodItem foodItem = getItem(position);
                item.setText(foodItem.getName() + " - $" + String.format("%.2f", foodItem.getPrice()));
                return item;
            }
        };
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener((parent, view, position, id) -> {
            FoodItem item = adapter.getItem(position);
            Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("price", item.getPrice());
            intent.putExtra("imageResId", item.getImageResId());
            startActivity(intent);
        });

        seeCartButton.setOnClickListener(v -> {
            startActivity(new Intent(FoodListActivity.this, CartActivity.class));
        });

        // Update total price text when resuming to this activity
        updateTotalPrice();
    }

    private void initializeData(String category) {
        foodItems = new ArrayList<>();
        switch (category) {
            case "Appetizers":
                foodItems.add(new FoodItem("Spring Rolls", "Delicious appetizer with veggies", 5.99, R.drawable.appetizer_spring_rolls));
                foodItems.add(new FoodItem("Bruschetta", "Toasted bread with tomato", 6.50, R.drawable.appetizer_bruschetta));
                break;
            case "Meals":
                foodItems.add(new FoodItem("Pasta Carbonara", "Creamy pasta with bacon", 12.00, R.drawable.meal_pasta));
                foodItems.add(new FoodItem("Grilled Steak", "Grilled steak with spices", 22.00, R.drawable.meal_steak));
                break;
            case "Drinks":
                foodItems.add(new FoodItem("Coffee", "Rich and aromatic coffee", 3.00, R.drawable.drink_coffee));
                foodItems.add(new FoodItem("Smoothie", "Fruit smoothie", 4.50, R.drawable.drink_smoothie));
                break;
            case "Desserts":
                foodItems.add(new FoodItem("Cake", "Moist cake with frosting", 5.00, R.drawable.dessert_cake));
                foodItems.add(new FoodItem("Ice Cream", "Creamy ice cream", 4.00, R.drawable.dessert_ice_cream));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double total = CartManager.getInstance().getTotalPrice();
        totalPriceText.setText(String.format("Total: $%.2f", total));
    }
}