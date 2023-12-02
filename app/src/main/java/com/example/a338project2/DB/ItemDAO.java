package com.example.a338project2.DB;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a338project2.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    void insert(Item... items);

    @Update
    void update(Item... items);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM " + AppDataBase.ITEMS_TABLE)
    List<Item> getItems();

    @Query("SELECT * FROM " + AppDataBase.ITEMS_TABLE + " WHERE itemId = :itemId")
    Item getItemById(int itemId);
}
