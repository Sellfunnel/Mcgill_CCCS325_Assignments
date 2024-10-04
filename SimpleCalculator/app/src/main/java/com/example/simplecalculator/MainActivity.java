package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerAdd1, spinnerAdd2, spinnerDiv1, spinnerDiv2;
    private TextView textViewAddResult, textViewDivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIComponents();
        setupSpinners();
        setupButtonClickListener();
    }

    private void initializeUIComponents() {
        spinnerAdd1 = findViewById(R.id.spinnerAdd1);
        spinnerAdd2 = findViewById(R.id.spinnerAdd2);
        spinnerDiv1 = findViewById(R.id.spinnerDiv1);
        spinnerDiv2 = findViewById(R.id.spinnerDiv2);
        textViewAddResult = findViewById(R.id.textViewAddResult);
        textViewDivResult = findViewById(R.id.textViewDivResult);
    }

    private void setupSpinners() {
        // ArrayAdapter for spinnerAdd1
        ArrayAdapter<CharSequence> adapterAdd1 = ArrayAdapter.createFromResource(
                this, R.array.numbers_add1, android.R.layout.simple_spinner_item);
        adapterAdd1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdd1.setAdapter(adapterAdd1);

        // ArrayAdapter for spinnerAdd2
        ArrayAdapter<CharSequence> adapterAdd2 = ArrayAdapter.createFromResource(
                this, R.array.numbers_add2, android.R.layout.simple_spinner_item);
        adapterAdd2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdd2.setAdapter(adapterAdd2);

        // ArrayAdapter for spinnerDiv1
        ArrayAdapter<CharSequence> adapterDiv1 = ArrayAdapter.createFromResource(
                this, R.array.numbers_div1, android.R.layout.simple_spinner_item);
        adapterDiv1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiv1.setAdapter(adapterDiv1);

        // ArrayAdapter for spinnerDiv2
        ArrayAdapter<CharSequence> adapterDiv2 = ArrayAdapter.createFromResource(
                this, R.array.numbers_div2, android.R.layout.simple_spinner_item);
        adapterDiv2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiv2.setAdapter(adapterDiv2);
    }

    private void setupButtonClickListener() {
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        int add1 = Integer.parseInt(spinnerAdd1.getSelectedItem().toString());
        int add2 = Integer.parseInt(spinnerAdd2.getSelectedItem().toString());
        int sum = add1 + add2;
        textViewAddResult.setText("=" + sum);

        int div1 = Integer.parseInt(spinnerDiv1.getSelectedItem().toString());
        int div2 = Integer.parseInt(spinnerDiv2.getSelectedItem().toString());
        String divResult = calculateDivisionResult(div1, div2);
        textViewDivResult.setText("=" + divResult);
    }

    private String calculateDivisionResult(int numerator, int denominator) {
        if (denominator == 0) {
            return "Infinity";  // Return "Infinity" if the denominator is zero
        }
        else {
            double result = (double) numerator / denominator;
            return String.format("%.2f", result);  // Round to 2 decimal places
        }
    }
}
