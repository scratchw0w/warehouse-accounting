package com.scratchy.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
 
    @GetMapping("/")
    public String welcomePage(){
        return "welcome-page";
    }

    @GetMapping("/form")
    public String formPage(){
        return "form-page";
    }

}