package com.scratchy.warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "itemData")
public class Item {
    
    @Id
    private String id;
    
    @Field(value = "name")
    private String name;
    
    @Field(value = "count")
    private int count;

    public Item(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", count: " + count;
    }
}