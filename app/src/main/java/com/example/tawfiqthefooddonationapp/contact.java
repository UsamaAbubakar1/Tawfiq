package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
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

public class contact extends AppCompatActivity {
    EditText name, email, message;
    Button submit;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        message = findViewById(R.id.message);
        submit = findViewById(R.id.submit);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString().trim();
                String Email= email.getText().toString().trim();
                String Message= message.getText().toString().trim();

                if (TextUtils.isEmpty(Name)) {
                    name.setError("Full Name required");
                    return;
                }

                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email is required");
                    return;
                } else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    email.setError("Please Enter Valid Email");
                    return;
                }

                if (TextUtils.isEmpty(Message)){
                    message.setError("Message Or suggestion is required");
                    return;
                }

                if (fAuth.getCurrentUser() != null) {

                    userID = fAuth.getCurrentUser().getUid();
                    //DocumentReference documentReference = fStore.collection("donate").document(userID);
                    CollectionReference collectionReference = fStore.collection("contact data");

                    Map<String, Object> user = new HashMap<>();
                    user.put("timestamp", FieldValue.serverTimestamp());
                    user.put("name", Name);
                    user.put("email", Email);
                    user.put("message", Message);
                    user.put("userid", userID);

                    Task<DocumentReference> documentReferenceTask = collectionReference.add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getApplicationContext(), "Successfully! We will shortly revert you back.", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Successfully! We will shortly revert you back.");
                                    //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Intent intent = new Intent(contact.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
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




