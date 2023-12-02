package com.example.a338project2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.a338project2.DB.AppDataBase;

@Entity(tableName = AppDataBase.USERS_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int userId;

    private String username;
    private String password;
    private boolean admin;

    public User(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
