package com.example.healthtracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Spinner spinnerBackgrounds;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        spinnerBackgrounds = findViewById(R.id.spinnerBackgrounds);
        buttonConfirm = findViewById(R.id.buttonConfirm);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.background_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBackgrounds.setAdapter(adapter);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedTheme = spinnerBackgrounds.getSelectedItem().toString();
                saveThemeSetting(selectedTheme);
                Toast.makeText(SettingsActivity.this, "Background updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void saveThemeSetting(String theme) {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.KEY_BACKGROUND, theme);
        editor.apply();
    }
}