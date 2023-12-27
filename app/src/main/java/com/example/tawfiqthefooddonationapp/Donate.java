package com.example.tawfiqthefooddonationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class Donate extends AppCompatActivity {

    EditText editName, editFood, editPhone, editAddress;
    Button mSubmitBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        fAuth=FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();

        editName = findViewById(R.id.editTextName_d);
        editFood = findViewById(R.id.editTextFoodItems);
        editPhone = findViewById(R.id.editTextPhoneNumber_d);
        editAddress = findViewById(R.id.editTextaddress);
        mSubmitBtn = findViewById(R.id.buttonDonate);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname = editName.getText().toString().trim();
                String fooditem = editFood.getText().toString().trim();
                String Address = editAddress.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();
                String type = "Donor";

                if (TextUtils.isEmpty(fullname)) {
                    editName.setError("Name is Required.");
                    return;
                }

                if (TextUtils.isEmpty(fooditem)) {
                    editFood.setError("Required.");
                    return;
                }

                if (phone.length() < 11) {
                    editPhone.setError("Phone Number Must be >=11 Characters");
                    return;
                }
                if (fAuth.getCurrentUser() != null) {

                    userID = fAuth.getCurrentUser().getUid();
                    //DocumentReference documentReference = fStore.collection("donate").document(userID);
                    CollectionReference collectionReference = fStore.collection("user donor");

                    Map<String, Object> user = new HashMap<>();
                    user.put("timestamp", FieldValue.serverTimestamp());
                    user.put("name", fullname);
                    user.put("food item", fooditem);
                    user.put("phone", phone);
                    user.put("address", Address);
                    user.put("userid", userID);
                    user.put("type", type);

                    Task<DocumentReference> documentReferenceTask = collectionReference.add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getApplicationContext(), "Thank you for your generous food donation! Your support is helping us make a difference one meal at a time.", Toast.LENGTH_LONG).show();
                                    Log.d(TAG, "Success!");
                                    //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Intent intent = new Intent(Donate.this, MainActivity.class);
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
