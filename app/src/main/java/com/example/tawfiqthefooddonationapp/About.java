package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    ImageView fb, linkedln, twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        fb = findViewById(R.id.imgFb);
        linkedln = findViewById(R.id.imgLink);
        twitter = findViewById(R.id.imgTwt);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.facebook.com/musamaabubakar/"));
                startActivity(myWeblink);
            }
        });

        linkedln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.linkedin.com/in/muhammad-usama-abubakar-530744281/"));
                startActivity(myWeblink);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://x.com/mu_abubakar1?t=XuAG3lx9aWz2DmBuZV8Oqw&s=09"));
                startActivity(myWeblink);
            }
        });
    }
}