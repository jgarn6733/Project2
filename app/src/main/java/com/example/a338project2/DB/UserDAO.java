package com.example.a338project2.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a338project2.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE)
    List<User> getUsers();

    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE + " WHERE username = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE + " WHERE userId = :userId")
    User getUserByUserId(int userId);
}
