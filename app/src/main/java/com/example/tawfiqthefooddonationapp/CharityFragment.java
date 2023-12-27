package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class CharityFragment extends Fragment {

    Button khidmat, edhi, skhospital, chipa, jdc, saylani;

    ImageView alkhidmatimg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_charity, container, false);

        khidmat = rootView.findViewById(R.id.btnkhidmat);
        edhi = rootView.findViewById(R.id.btnedhi);
        skhospital = rootView.findViewById(R.id.skHosppital);
        chipa = rootView.findViewById(R.id.chipa);
        jdc = rootView.findViewById(R.id.jdc);
        saylani = rootView.findViewById(R.id.saylani);

        alkhidmatimg = rootView.findViewById(R.id.Alkidmat_img);
        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Alkhidmat_Foundation_Pakistan.png/800px-Alkhidmat_Foundation_Pakistan.png").into(alkhidmatimg);

        khidmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://alkhidmat.org/donate"));
                startActivity(myWeblink);
            }
        });

        edhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://edhi.org/donate-us/"));
                startActivity(myWeblink);
            }
        });

        skhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://shaukatkhanum.org.pk/online-donation-box/?gclid=Cj0KCQjw0vWnBhC6ARIsAJpJM6c5lC-U0eDQJRRe1roaAjOF_9fByieyRIlS-9VDoyxf-qk34D0XjNMaAhsoEALw_wcB"));
                startActivity(myWeblink);
            }
        });

        chipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.chhipa.org/donate/"));
                startActivity(myWeblink);
            }
        });

        jdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://jdcwelfare.org/donation-form/"));
                startActivity(myWeblink);
            }
        });

        saylani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.saylaniwelfareusa.com/en/donate"));
                startActivity(myWeblink);
            }
        });




        return rootView;


    }
}