package com.example.a338project2;

import androidx.room.PrimaryKey;

import com.example.a338project2.DB.ItemDAO;

import java.util.List;

public class Cart {
    @PrimaryKey(autoGenerate = true)
    private int cartId;

    private List<Item> itemList;
    private int price;
    private ItemDAO itemDao;

    public Cart(List<Item> itemList, int price) {
        this.itemList = itemList;
        this.price = price;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
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
}
