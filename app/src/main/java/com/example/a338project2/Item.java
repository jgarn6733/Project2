package com.example.a338project2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.a338project2.DB.AppDataBase;

@Entity(tableName = AppDataBase.ITEMS_TABLE)
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int itemId;

    private String itemName;
    private String itemDescription;
    private int itemPrice;

    public Item(String itemName, String itemDescription, int itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
