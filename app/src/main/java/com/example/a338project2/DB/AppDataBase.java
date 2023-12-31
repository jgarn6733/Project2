package com.example.a338project2.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a338project2.Cart;
import com.example.a338project2.Item;
import com.example.a338project2.User;

@Database(entities = {User.class, Item.class, Cart.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "CapitalShopping.db";
    public static final String USERS_TABLE = "users_table";
    public static final String ITEMS_TABLE = "items_table";
    public static final String CARTS_TABLE = "carts_table";

    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public abstract UserDAO UserDAO();
    public abstract ItemDAO ItemDAO();
    public abstract CartDAO CartDAO();

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }
}
