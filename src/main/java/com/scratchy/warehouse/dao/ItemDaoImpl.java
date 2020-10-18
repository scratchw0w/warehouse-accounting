package com.scratchy.warehouse.dao;

import java.util.List;

import com.scratchy.warehouse.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    MongoTemplate dataBase;

    @Override
    public List<Item> getItems() {
        List<Item> items = dataBase.findAll(Item.class);
        return items;
    }

    @Override
    public Item getItemByName(String name) {
        name = name.toLowerCase();
        Item item = dataBase.findOne(Query.query(Criteria.where("name").is(name)), Item.class);
        return item;
    }

    @Override
    public Item addItem(Item newItem) {
        String name = newItem.getName();
        newItem.setName(name.toLowerCase());
        return dataBase.insert(newItem, "itemData");
    }

    @Override
    public Item updateItemByName(Item newItem) {
        Item previousItem = dataBase.findOne(Query.query(Criteria.where(newItem.getName().toLowerCase())), Item.class);
        Update update = new Update();
        update.set("count", newItem.getCount());
        dataBase.updateFirst(Query.query(Criteria.where("_id").is(previousItem.getId())), update, Item.class);
        return getItemByName(newItem.getName().toLowerCase());
    }

    @Override
    public void deleteItemByName(String name) {
        name = name.toLowerCase();
        dataBase.remove(Query.query(Criteria.where("name").is(name)), Item.class);
    }
    
}