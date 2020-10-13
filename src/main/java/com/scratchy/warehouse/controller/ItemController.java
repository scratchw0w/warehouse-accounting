package com.scratchy.warehouse.controller;

import com.scratchy.warehouse.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ItemController {

    @Autowired
    MongoTemplate dataBase;

    @GetMapping("/")
    public String mainPage(){
        List<Item> items = dataBase.findAll(Item.class);
        for (Item tempItem : items) {
            System.out.println(tempItem);
        }
        return "welcome-page";
    }

}