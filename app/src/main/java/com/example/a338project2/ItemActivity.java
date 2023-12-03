package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.a338project2.DB.ItemDAO;

public class ItemActivity extends AppCompatActivity {

    Intent intent = getIntent();
    String itemName = intent.getStringExtra("itemName");
    ItemDAO itemDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, ItemActivity.class);
        return intent;
    }
}