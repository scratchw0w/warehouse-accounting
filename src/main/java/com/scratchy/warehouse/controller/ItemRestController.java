package com.scratchy.warehouse.controller;

import com.scratchy.warehouse.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemRestController {

    @Autowired
    MongoTemplate dataBase;

    @GetMapping("items")
    public List<Item> getItems() {
        List<Item> items = dataBase.findAll(Item.class);
        for (Item tempItem : items) {
            System.out.println(tempItem);
        }
        return items;
    }

    // TODO: ignore case
    @GetMapping("items/{item_name}")
    public Item getItemByName(@PathVariable("item_name") String name){
        Item item = dataBase.findOne(Query.query(Criteria.where("name").is(name)), Item.class);
        System.out.println(item);
        return item;
    }

    // TODO:
    @PostMapping("items")
    public void addItem(Item item) {
        if(item == null){
            System.out.println("No item exists!");
            return;
        }
        dataBase.insert(item, "itemData");
    }

    // TODO:
    @PutMapping("items/{item_name}")
    public void updateItemByName(@PathVariable("item_name") String updatingEntityName) {
        Item anotherItem = new Item("Laptop", 10);
        Update update = new Update();
        update.set("name", anotherItem.getName());
        update.set("count", anotherItem.getCount());
        dataBase.updateFirst(Query.query(Criteria.where("name").is(updatingEntityName)), update, Item.class);
    }

    // TODO: ignore case
    @DeleteMapping("items/{item_name}")
    public void deleteItemByName(@PathVariable("item_name") String name) {
        dataBase.remove(Query.query(Criteria.where("name").is(name)), Item.class);
    }

}