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
        Item item = dataBase.findOne(Query.query(Criteria.where("name").is(stringToLowerCase(name))), Item.class);
        return item;
    }

    @Override
    public void addItem(Item newItem) {
        newItem.setName(stringToLowerCase(newItem.getName()));
        dataBase.insert(newItem, "itemData");
    }

    @Override
    public void updateItemByName(Item updatedItem) {
        String nameOfItemToUpdate = stringToLowerCase(updatedItem.getName());
        Update update = new Update();
        update.set("count", updatedItem.getCount());
        dataBase.updateFirst(Query.query(Criteria.where("name").is(nameOfItemToUpdate)), update, Item.class);
    }

    @Override
    public void deleteItemByName(String name) {
        dataBase.remove(Query.query(Criteria.where("name").is(stringToLowerCase(name))), Item.class);
    }

    private String stringToLowerCase(String sourceString){
        return sourceString.toLowerCase();
    }
    
}