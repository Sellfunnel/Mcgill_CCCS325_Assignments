package com.example.foodmenuapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView itemDescription, itemPrice;
    private EditText quantityInput;
    private ImageView itemImage;
    private Button addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        itemDescription = findViewById(R.id.itemDescription);
        itemPrice = findViewById(R.id.itemPrice);
        quantityInput = findViewById(R.id.quantityInput);
        itemImage = findViewById(R.id.itemImage);
        addToCartButton = findViewById(R.id.addToCartButton);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        double price = intent.getDoubleExtra("price", 0);
        int imageResId = intent.getIntExtra("imageResId", 0);
        String name = intent.getStringExtra("name");

        itemDescription.setText(description);
        itemPrice.setText(String.format("Price: $%.2f", price));
        itemImage.setImageResource(imageResId);

        addToCartButton.setOnClickListener(v -> {
            try {
                int quantity = Integer.parseInt(quantityInput.getText().toString());
                if (quantity > 0) {
                    CartManager.getInstance().addToCart(new CartItem(name, price, quantity));
                    startActivity(new Intent(DetailActivity.this, CartActivity.class));
                } else {
                    quantityInput.setError("Quantity must be greater than 0");
                }
            } catch (NumberFormatException e) {
                quantityInput.setError("Please enter a valid number");
            }
        });
    }
}