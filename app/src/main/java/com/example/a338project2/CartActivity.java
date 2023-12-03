package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a338project2.DB.CartDAO;
import com.example.a338project2.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    TextView total;
    Button returnButton;
    Button clearButton;
    Button purchaseButton;
    ActivityCartBinding binding;
    CartDAO cartDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        total = binding.total;
        returnButton = binding.returnButton2;
        clearButton = binding.clearButton;
        purchaseButton = binding.purchaseButton;

        SharedPreferences sharedPref = getApplicationContext()
                .getSharedPreferences("UserSharedPref", Context.MODE_PRIVATE);
        int userId = sharedPref.getInt("UserId", 0);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LandingPage.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCart(userId);
            }
        });
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseCart(userId);
            }
        });
    }

    private void purchaseCart(int userId) {
        Cart cart = cartDao.getCart(userId);
        int total = cart.purchase();
    }

    private void clearCart(int userId) {
        Cart cart = cartDao.getCart(userId);
        cart.clear();
        cartDao.update(cart);
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, CartActivity.class);
        return intent;
    }
}