package com.scratchy.warehouse.controller;

import com.scratchy.warehouse.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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

    @GetMapping("items/{item_name}")
    public Item getItemByName(@PathVariable("item_name") String name){
        name = name.toLowerCase();
        Item item = dataBase.findOne(Query.query(Criteria.where("name").is(name)), Item.class);
        System.out.println(item);
        return item;
    }

    @PostMapping("items")
    public void addItem(@RequestAttribute("newItem") Item newItem) {
        String name = newItem.getName();
        newItem.setName(name.toLowerCase());
        dataBase.insert(newItem, "itemData");
    }

    @PutMapping("items/{item_name}")
    public void updateItemByName(@PathVariable("item_name") String updatingEntityName, @ModelAttribute("item") Item newItem) {
        updatingEntityName = updatingEntityName.toLowerCase();
        Update update = new Update();
        update.set("name", newItem.getName());
        update.set("count", newItem.getCount());
        dataBase.updateFirst(Query.query(Criteria.where("name").is(updatingEntityName)), update, Item.class);
    }

    @DeleteMapping("items/{item_name}")
    public void deleteItemByName(@PathVariable("item_name") String name) {
        name = name.toLowerCase();
        dataBase.remove(Query.query(Criteria.where("name").is(name)), Item.class);
    }

}