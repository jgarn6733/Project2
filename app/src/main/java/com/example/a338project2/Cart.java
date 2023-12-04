package com.example.a338project2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.a338project2.DB.AppDataBase;
import com.example.a338project2.DB.ItemDAO;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = AppDataBase.CARTS_TABLE)
public class Cart {
    @PrimaryKey(autoGenerate = true)
    private int cartId;

    private ArrayList<Item> itemList;
    private int price;


    public Cart(ArrayList<Item> itemList, int price) {
        this.itemList = itemList;
        this.price = price;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean addItem(int itemId) {
        Item newItem = itemDao.getItemById(itemId);
        if (newItem == null) {
            return false;
        } else {
            itemList.add(newItem);
            return true;
        }
    }

    public void clear() {
        itemList = new ArrayList<>();
        price = 0;
    }

    public int purchase() {
        int total = price;
        price = 0;
        itemList = new ArrayList<>();
        return total;
    }
}
