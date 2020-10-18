package com.scratchy.warehouse.controller;

import com.scratchy.warehouse.model.Item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
 
    @GetMapping("/")
    public String welcomePage(){
        return "welcome-page";
    }

    @GetMapping("/addItem")
    public String addFormPage(Model theModel){
        theModel.addAttribute("newItem", new Item());
        return "add-form-page";
    }

    @GetMapping("/updateItem")
    public String updateFormPage(Model theModel){
        theModel.addAttribute("newItem", new Item());
        return "update-form-page";
    }

}