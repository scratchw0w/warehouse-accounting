package com.scratchy.warehouse.service;

import java.util.List;

import com.scratchy.warehouse.model.Item;

public interface ItemService {

    public List<Item> getItems();
    public Item getItemByName(String name);
    public Item addItem(Item newItem);
    public Item updateItemByName(Item newItem);
    public void deleteItemByName(String name);

}