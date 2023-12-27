package com.example.tawfiqthefooddonationapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class nearbyngo extends AppCompatActivity {

    EditText edtLocation;
    Button btnSubmit;
    String location;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearbyngo);

        edtLocation = findViewById(R.id.nearbyngolocation);
        btnSubmit = findViewById(R.id.nearbyngosubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = edtLocation.getText().toString().trim();
                if (location.isEmpty()) {
                    edtLocation.setError("Please enter the location");
                } else {
                    if (checkInternetConnection()) {
                        String url = "https://www.google.com/search?q=ngos%20near%20" + location;
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            connected = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            if (!connected) {
                Toast.makeText(nearbyngo.this, "Network Unavailable", Toast.LENGTH_SHORT).show();
            }
        }
        return connected;
    }
}
