package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.a338project2.databinding.ActivityShopBinding;

public class ShopActivity extends AppCompatActivity {
    ActivityShopBinding binding;
    TextView title;
    Button returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        binding = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, ShopActivity.class);
        return intent;
    }
}