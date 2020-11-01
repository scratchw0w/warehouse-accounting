package com.scratchy.warehouse.service;

import java.util.List;

import com.scratchy.warehouse.dao.ItemDao;
import com.scratchy.warehouse.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    @Transactional
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    @Transactional
    public Item getItemByName(String name) {
        return itemDao.getItemByName(name);
    }

    @Override
    @Transactional
    public void addItem(Item newItem) {
        itemDao.addItem(newItem);
    }

    @Override
    @Transactional
    public void updateItemByName(Item updatedItem) {
        itemDao.updateItemByName(updatedItem);
    }

    @Override
    @Transactional
    public void deleteItemByName(String name) {
        itemDao.deleteItemByName(name);
    }
    
}