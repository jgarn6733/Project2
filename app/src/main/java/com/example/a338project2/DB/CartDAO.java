package com.example.a338project2.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a338project2.Cart;

@Dao
public interface CartDAO {
    @Insert
    void insert(Cart... carts);

    @Update
    void update(Cart... carts);

    @Delete
    void delete(Cart cart);

    @Query("SELECT * FROM " + AppDataBase.CARTS_TABLE + " WHERE cartId = :cartId")
    Cart getCart(int cartId);
}
