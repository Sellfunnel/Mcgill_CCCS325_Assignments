package com.example.healthtracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private TextView bmiResult;
    private ImageView backgroundView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        bmiResult = findViewById(R.id.bmiResult);
        backgroundView = findViewById(R.id.mainBackground);
        Button calculateBmiButton = findViewById(R.id.calculateBmiButton);
        ImageView settingsButton = findViewById(R.id.settingsButton);

        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState); // Restore from saved instance state if available
        } else {
            bmiResult.setText("Your BMI");
        }

        applyBackgroundTheme();

        calculateBmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current state of the BMI result
        outState.putString("bmiResult", bmiResult.getText().toString());
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        // Restore BMI result from the saved instance state
        bmiResult.setText(savedInstanceState.getString("bmiResult", "Your BMI"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        applyBackgroundTheme();
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();
        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            try {
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr);
                if (height != 0) {
                    float bmi = weight / (height * height);
                    bmiResult.setText(String.format("%.2f", bmi));
                } else {
                    showErrorMessage("Height cannot be zero");
                }
            } catch (NumberFormatException e) {
                showErrorMessage("Please enter valid numbers");
            }
        } else {
            showErrorMessage("Please enter both weight and height");
        }
    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void applyBackgroundTheme() {
        String theme = sharedPreferences.getString("background_theme", "Default");
        switch (theme) {
            case "Default":
                backgroundView.setImageDrawable(null);
                break;
            case "Warm":
                backgroundView.setImageResource(R.drawable.warm_image);
                break;
            case "Cold":
                backgroundView.setImageResource(R.drawable.cold_image);
                break;
        }
    }
}