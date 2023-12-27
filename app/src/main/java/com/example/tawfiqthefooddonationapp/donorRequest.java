package com.example.tawfiqthefooddonationapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class donorRequest extends AppCompatActivity {

    RecyclerView recView;
    private FirebaseFirestore fStore;
    myadapter adapter;
    ArrayList<model> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_request);

        // Initialize Firestore
        fStore = FirebaseFirestore.getInstance();

        // Initialize UI elements
        recView = findViewById(R.id.recview);
        recView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        adapter = new myadapter(dataList);
        recView.setAdapter(adapter);

        // Fetch donor details from Firestore based on userID
        fStore.collection("user donor").orderBy("timestamp", Query.Direction.DESCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        if (dataList != null) {
                            dataList.clear();
                            for (DocumentSnapshot d : list) {
                                model obj = d.toObject(model.class);
                                dataList.add(obj);
                            }
                            // update adapter here
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}
