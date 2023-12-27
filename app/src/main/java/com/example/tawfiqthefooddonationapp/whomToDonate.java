package com.example.tawfiqthefooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class whomToDonate extends AppCompatActivity {

    TextView tvWhom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whom_to_donate);

        tvWhom = findViewById(R.id.tvwhom);

    }
}