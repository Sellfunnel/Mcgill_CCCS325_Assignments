package com.example.information;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup fontSizeOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fontSizeOptions = findViewById(R.id.fontSizeOptions);
        Button confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = fontSizeOptions.getCheckedRadioButtonId();
                float size = 18; // Default to medium size
                if (selectedId == R.id.smallFont) {
                    size = 14; // Small size
                } else if (selectedId == R.id.largeFont) {
                    size = 22; // Large size
                }

                // Save the selected font size
                SharedPreferences.Editor editor = getSharedPreferences("AppPrefs", MODE_PRIVATE).edit();
                editor.putFloat("fontSize", size);
                editor.apply();

                // Close the activity
                finish();
            }
        });
    }
}