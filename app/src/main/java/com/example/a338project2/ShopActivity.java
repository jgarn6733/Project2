package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        title = binding.TitleTextView;
        returnButton = binding.returnButton;
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = LandingPage.intentFactory(getApplicationContext());
                startActivity(newIntent);
            }
        });

    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, ShopActivity.class);
        return intent;
    }
}