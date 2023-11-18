package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a338project2.DB.AppDataBase;
import com.example.a338project2.DB.UserDAO;
import com.example.a338project2.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView MainDisplay;
    Button login;
    Button signup;

    UserDAO userDAO;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getApplicationContext()
                .getSharedPreferences("UserSharedPref", Context.MODE_PRIVATE);
        int userId = sharedPref.getInt("UserId", -1);
        if (userId != -1) {
            Intent intent = LandingPage.intentFactory(getApplicationContext());
            intent.putExtra("UserId", userId);
            startActivity(intent);
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainDisplay = binding.mainDisplay;
        login = binding.loginButton;
        signup = binding.signupButton;

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = LoginActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });


    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }


}