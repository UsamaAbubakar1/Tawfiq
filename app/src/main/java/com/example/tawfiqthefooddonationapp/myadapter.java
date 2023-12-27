package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<model> dataList;
    public static final String TAG = "TAG";
    FirebaseFirestore fStore;
    String userID;

    public myadapter(ArrayList<model> dataList) {
        this.dataList = dataList;
        fStore = FirebaseFirestore.getInstance();
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        if (dataList != null && dataList.size() > position) {

            holder.name.setText(dataList.get(position).getName());
            holder.food.setText(dataList.get(position).getFoodItem());
            holder.address.setText(dataList.get(position).getAddress());
            holder.number.setText(dataList.get(position).getPhone());
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView name, food, number, address, completeDonation;
        Button accept, reject;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.d_name);
            food = itemView.findViewById(R.id.food_item);
            number = itemView.findViewById(R.id.d_phone);
            address = itemView.findViewById(R.id.d_address);
            completeDonation = itemView.findViewById(R.id.compltedonation);
            accept = itemView.findViewById(R.id.buttonAccept);
            reject = itemView.findViewById(R.id.buttonReject);

            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    completeDonation.setVisibility(View.VISIBLE);
                    userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    // Assuming you have a user document in Firestore for the current user.
                    DocumentReference donorDocument = fStore.collection("user donor").document(userID);

                    donorDocument.delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // The document was successfully deleted.
                                    // You can perform any additional actions here.
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Handle the error in case of a failure.
                                    Toast.makeText(view.getContext(), "Error!", Toast.LENGTH_SHORT).show();
                                    Log.w(TAG, "Error deleting document", e);
                                }
                            });


                    Intent intent = new Intent(view.getContext(), Timer.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);
                }
            });


            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), MainFragment.class);

                    // Start the main activity
                    view.getContext().startActivity(intent);
                }
            });
        }


    }


}
