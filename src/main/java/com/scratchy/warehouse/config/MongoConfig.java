package com.scratchy.warehouse.config;

import java.util.Collection;
import java.util.Collections;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration{
    
    @Override
    protected String getDatabaseName(){
        return "itemdb";
    }

    @Override
    public MongoClient mongoClient(){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/itemdb");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages(){
        return Collections.singleton("com.scratchy.warehouse");
    }

}