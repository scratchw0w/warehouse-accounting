package com.scratchy.warehouse.dao;

import java.util.List;

import com.scratchy.warehouse.model.Item;

public interface ItemDao {

    public List<Item> getItems();
    public Item getItemByName(String name);
    public void addItem(Item newItem);
    public void updateItemByName(Item updatedItem);
    public void deleteItemByName(String name);
    
}