package com.example.tawfiqthefooddonationapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;


public class MainFragment extends Fragment {

    CardView donate, receive,nearByngo, share, about, contact, logout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        donate = rootView.findViewById(R.id.cardDonate);
        receive = rootView.findViewById(R.id.cardReceive);
        share = rootView.findViewById(R.id.cardshare);
        about = rootView.findViewById(R.id.cardAboutus);
        contact = rootView.findViewById(R.id.cardContact);
        nearByngo = rootView.findViewById(R.id.cardnearbyngo);
        logout = rootView.findViewById(R.id.cardLogout);



        donate.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Donate.class);
            startActivity(intent);
        });

        receive.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Receive.class);
            startActivity(intent);
        });

        nearByngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), nearbyngo.class);
                startActivity(intent);
            }
        });


        share.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Share.class);
            startActivity(intent);
        });

        about.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), About.class);
            startActivity(intent);
        });

        contact.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), com.example.tawfiqthefooddonationapp.contact.class);
            startActivity(intent);
        });

        logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                    .setTitle("Logout Tawfiq")
                    .setMessage("Are you sure you want to logout!")
                    .setIcon(R.drawable.logoutdialog)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getActivity(), Logup.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                builder.show();

        });


        return rootView;
    }
}