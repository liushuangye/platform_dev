package com.platform.dev;

import com.platform.dev.beans.MongoUtils;
import com.platform.dev.beans.RedisUtils;
import com.platform.dev.beans.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevApplicationTests {
    @Autowired
    Person person;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    MongoUtils mongoUtils;
    @Test
    void contextLoads() {
//        System.out.println(person.toString());
//        redisUtils.set("name","xiaoming");
//        System.out.println(redisUtils.get("name"));

        mongoUtils.insert();
        mongoUtils.find();
    }

}
