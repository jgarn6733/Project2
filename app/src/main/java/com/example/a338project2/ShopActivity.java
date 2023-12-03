package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a338project2.DB.ItemDAO;
import com.example.a338project2.databinding.ActivityShopBinding;

import java.util.List;

public class ShopActivity extends AppCompatActivity {
    ActivityShopBinding binding;
    TextView title;
    Button returnButton;
    Button searchButton;
    EditText searchTerm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        binding = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title = binding.TitleTextView;
        returnButton = binding.returnButton;
        searchButton = binding.searchButton;
        searchTerm = binding.searchTerm;


        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = LandingPage.intentFactory(getApplicationContext());
                startActivity(newIntent);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ItemActivity.intentFactory(getApplicationContext());
                intent.putExtra("itemName", searchTerm.getText().toString());
                startActivity(intent);
            }
        });
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, ShopActivity.class);
        return intent;
    }
}