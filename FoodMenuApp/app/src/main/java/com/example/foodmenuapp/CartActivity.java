package com.example.foodmenuapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;
    Button clearCartButton;
    TextView totalPriceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        clearCartButton = findViewById(R.id.clearCartButton);
        totalPriceText = findViewById(R.id.totalPriceText);

        updateCartDisplay();

        clearCartButton.setOnClickListener(v -> {
            CartManager.getInstance().clearCart();
            updateCartDisplay();  // Update UI after clearing the cart
        });
    }

    private void updateCartDisplay() {
        List<CartItem> cartItems = CartManager.getInstance().getCartItems();
        ArrayAdapter<CartItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(adapter);
        totalPriceText.setText(String.format("Total: $%.2f", CartManager.getInstance().getTotalPrice()));
    }
}