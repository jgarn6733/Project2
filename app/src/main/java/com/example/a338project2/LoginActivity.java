package com.example.a338project2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a338project2.DB.AppDataBase;
import com.example.a338project2.DB.CartDAO;
import com.example.a338project2.DB.ItemDAO;
import com.example.a338project2.DB.UserDAO;
import com.example.a338project2.databinding.ActivityLoginBinding;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    Button login;

    ActivityLoginBinding binding;

    UserDAO UserDAO;
    ItemDAO itemDAO;
    CartDAO cartDAO;
    List<User> UsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .build().UserDAO();
        itemDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .build().ItemDAO();
        cartDAO = Room.databaseBuilder(this,AppDataBase.class, AppDataBase.DATABASE_NAME)
                .build().CartDAO();

        username = binding.loginUsername;
        password = binding.loginPassword;
        login = binding.loginSubmitButton;
        UsersList = UserDAO.getUsers();
        if (UsersList.size() <= 0) {
            User testUser = new User("testuser1", "testuser1", false);
            User admin = new User("admin2", "admin2", true);
            UserDAO.insert(testUser, admin);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (User u : UsersList) {
                    if ((u.getUsername().equals(username.getText().toString())) && (u.getPassword().equals(password.getText().toString()))) {
                        Intent intent  = LandingPage.intentFactory(getApplicationContext());
                        intent.putExtra("UserId", u.getUserId());

                        SharedPreferences sharedPref = getApplicationContext()
                                .getSharedPreferences("UserSharedPref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("UserId", u.getUserId());
                        editor.apply();

                        startActivity(intent);
                    }
                }
            }
        });
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, LoginActivity.class);
        return intent;
    }
}