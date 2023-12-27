package com.example.tawfiqthefooddonationapp;

import com.google.firebase.firestore.PropertyName;

public class model {
    String name;

    @PropertyName("food item")
    String foodItem;

    String phone;
    String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PropertyName("food item")
    public String getFoodItem() {
        return foodItem;
    }

    @PropertyName("food item")
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
