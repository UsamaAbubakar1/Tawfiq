package com.example.tawfiqthefooddonationapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<model> dataList;

    public myadapter(ArrayList<model> dataList) {
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        //Fetch data
        holder.name.setText(dataList.get(position).getName());
        holder.food.setText(dataList.get(position).getFoodItem());
        holder.address.setText(dataList.get(position).getAddress());
        holder.number.setText(dataList.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

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
