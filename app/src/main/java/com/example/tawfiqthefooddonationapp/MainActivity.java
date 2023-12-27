package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tawfiq");


        ViewPagerMessengerAdapter sectionsPagerAdapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tab_layout);
        tabs.setupWithViewPager(viewPager);

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawarLayout);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        String userId = getIntent().getStringExtra("user_id");

        updateNavigationHeader(userId);


    }

    private void updateNavigationHeader(String userId) {
        View headerView = navigationView.getHeaderView(0);
        TextView userNameTextView = headerView.findViewById(R.id.userIdName);

        if (userId != null) {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            // Fetch user name from Firestore
            db.collection("users").document(userId)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                String userName = document.getString("name");
                                userNameTextView.setText(userName);


                            } else {
                                Log.d("Firestore", "Document not found for user ID: " + userId);
                            }
                        } else {
                            Log.e("Firestore", "Error getting user document", task.getException());
                        }
                    });
        } else {
            Log.e("Firestore", "User ID is null");
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.whyToDonateMenu){
            Intent intent = new Intent(getApplicationContext(), whyToDonate.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.whomToDonateMenu) {
            Intent intent = new Intent(getApplicationContext(), whomToDonate.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
            startActivity(intent);
        } else if (item.getItemId() == R.id.donateUsMenu) {
            Intent intent = new Intent(getApplicationContext(), donateUs.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
            startActivity(intent);
        }
        return false;
    }
}
