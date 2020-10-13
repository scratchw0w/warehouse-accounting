package com.scratchy.warehouse.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Item {
    
    @Id
    private int id;
    private String name;
    private int count;


    public Item(String name, int count) {
        this.name = name;
        this.count = count;
    }
}