package com.example.information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;
    private TextView headerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = findViewById(R.id.infoTextView);
        headerTextView = findViewById(R.id.headerTextView);
        ImageView settingsButton = findViewById(R.id.settingsButton);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        updateTextSize();  // Update text size based on saved preferences
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTextSize();  // Ensure text size is updated whenever the activity resumes
    }

    private void updateTextSize() {
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        float fontSize = prefs.getFloat("fontSize", 18);  // Default to medium size

        // Apply the font size to both text views
        infoTextView.setTextSize(fontSize);
        headerTextView.setTextSize(fontSize);
    }
}