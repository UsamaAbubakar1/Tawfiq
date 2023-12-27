package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Receive extends AppCompatActivity {

    EditText name, number;
    Button rcvBtn;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        name = findViewById(R.id.editTextName_R);
        number = findViewById(R.id.editTextPhoneNumber_R);
        rcvBtn = findViewById(R.id.buttonRecv);


        rcvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = name.getText().toString().trim();
                String phone = number.getText().toString().trim();
                String type = "Receiver";

                if (TextUtils.isEmpty(fullname)) {
                    name.setError("Name is Required.");
                    return;
                }
                if (phone.length() < 10) {
                    number.setError("Phone Number Must be >=10 Characters");
                    return;
                }


                if (fAuth.getCurrentUser() != null) {

                    userID = fAuth.getCurrentUser().getUid();
                    //DocumentReference documentReference = fStore.collection("receiver").document(userID);
                    CollectionReference collectionReference = fStore.collection("user reciver");

                    Map<String, Object> user = new HashMap<>();
                    user.put("timestamp", FieldValue.serverTimestamp());
                    user.put("name", fullname);
                    user.put("phone", phone);
                    user.put("userid", userID);
                    user.put("type", type);

                    Task<DocumentReference> documentReferenceTask = collectionReference.add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {

                                    //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Intent intent = new Intent(Receive.this, donorRequest.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
                                    Log.w(TAG, "Error!", e);
                                }

                            });
                }
            }
        });
    }

}