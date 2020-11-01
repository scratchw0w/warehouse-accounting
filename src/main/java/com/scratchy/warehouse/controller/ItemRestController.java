package com.scratchy.warehouse.controller;

import com.scratchy.warehouse.model.Item;
import com.scratchy.warehouse.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemRestController {

    @Autowired
    ItemService itemDatabase;

    @GetMapping("api/items")
    public List<Item> getItems() {
        return itemDatabase.getItems();
    }

    @GetMapping("api/items/{item_name}")
    public Item getItemByName(@PathVariable("item_name") String name){
        return itemDatabase.getItemByName(name);
    }

    @PostMapping("api/items")
    public void addItem(@RequestBody Item newItem) {
        itemDatabase.addItem(newItem);
    }

    @PutMapping("api/items")
    public void updateItemByName(@RequestBody Item updatedItem) {
        itemDatabase.updateItemByName(updatedItem); 
    }

    @DeleteMapping("api/items/{item_name}")
    public void deleteItemByName(@PathVariable("item_name") String name) {
        itemDatabase.deleteItemByName(name);
    }

}