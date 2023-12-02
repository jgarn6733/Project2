package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, CartActivity.class);
        return intent;
    }
}