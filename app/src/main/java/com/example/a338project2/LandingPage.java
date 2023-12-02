package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a338project2.DB.UserDAO;
import com.example.a338project2.databinding.ActivityLandingPageBinding;

public class LandingPage extends AppCompatActivity {

    ActivityLandingPageBinding binding;
    User user;
    TextView usernameDisplay;
    Button logoutButton;
    Button shopButton;
    Button cartButton;
    Button adminButton;

    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int userId = intent.getIntExtra("UserId", 0);

        usernameDisplay = binding.UsernameText;
        logoutButton = binding.logoutButton;
        adminButton = binding.adminButton;
        shopButton = binding.shopButton;
        cartButton = binding.cartButton;

        user = userDAO.getUserByUserId(userId);

        if (user.isAdmin()) {
            adminButton.setVisibility(View.VISIBLE);
        }
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getApplicationContext()
                        .getSharedPreferences("UserSharedPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove("UserId");
                editor.apply();
                Intent intent = MainActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = ShopActivity.intentFactory(getApplicationContext());
                startActivity(newIntent);
            }
        });
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = CartActivity.intentFactory(getApplicationContext());
                startActivity(newIntent);
            }
        });
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, LandingPage.class);
        return intent;
    }
}