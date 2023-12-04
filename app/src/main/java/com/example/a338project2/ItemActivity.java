package com.example.a338project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a338project2.DB.CartDAO;
import com.example.a338project2.DB.ItemDAO;
import com.example.a338project2.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {

    TextView itemNameTextView;
    TextView itemDescTextView;
    Button addButton;
    Button backButton;
    ActivityItemBinding binding;
    ItemDAO itemDao;
    CartDAO cartDao;
    Cart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        binding = ActivityItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        itemNameTextView = binding.ItemName;
        itemDescTextView = binding.ItemDesc;
        addButton = binding.addButton;
        backButton = binding.backButton;

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("itemName");

        Item search = itemDao.getItemByName(itemName);

        SharedPreferences sharedPref = getApplicationContext()
                .getSharedPreferences("UserSharedPref", Context.MODE_PRIVATE);
        int userId = sharedPref.getInt("UserId", 0);

        cart = cartDao.getCart(userId);


        itemNameTextView.setText(search.getItemName());
        itemDescTextView.setText(search.getItemDescription());

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(search.getItemId());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ShopActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void addToCart(int itemId) {
        if(cart.addItem(itemId)) {
            Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add Item to cart", Toast.LENGTH_SHORT).show();
        }

    }

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, ItemActivity.class);
        return intent;
    }
}