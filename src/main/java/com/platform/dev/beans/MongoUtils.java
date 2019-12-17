package com.platform.dev.beans;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

@Component
public class MongoUtils {
    private Logger logger = LoggerFactory.getLogger(MongoUtils.class);
    private final MongoDbFactory mongo;
    private final MongoDatabase db;
    @Autowired
    public MongoUtils(MongoDbFactory mongo) {
        this.mongo = mongo;
        this.db = mongo.getDb();
    }

    /**
     * 读取
     */
    public String find() {
        logger.info("mongoUtils.find()");
        MongoCollection<Document> contections=db.getCollection("person");
        MongoCursor result1=    contections.find().iterator();
        while(result1.hasNext()) {
            System.out.println(result1.next());
        }
        return null;
    }

    /**
     * 写入
     */
    public boolean insert() {
//        MongoCollection<Document> contections=db.getCollection("person");
//        //插入
//        contections.insertOne(new Document("name","test456").append("sex", "男"));

        return true;
    }

}
