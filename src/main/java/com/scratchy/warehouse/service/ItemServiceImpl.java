package com.scratchy.warehouse.service;

import java.util.List;

import com.scratchy.warehouse.dao.ItemDao;
import com.scratchy.warehouse.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public Item getItemByName(String name) {
        return itemDao.getItemByName(name);
    }

    @Override
    public void addItem(Item newItem) {
        itemDao.addItem(newItem);
    }

    @Override
    public void updateItemByName(String oldItemName, Item newItem) {
        itemDao.updateItemByName(oldItemName, newItem);
    }

    @Override
    public void deleteItemByName(String name) {
        itemDao.deleteItemByName(name);
    }


    
}