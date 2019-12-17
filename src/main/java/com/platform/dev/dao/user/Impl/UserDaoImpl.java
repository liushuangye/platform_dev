package com.platform.dev.dao.user.Impl;

import com.platform.dev.dao.user.UserDao;
import com.platform.dev.entity.user.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public User findUserByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        //findOne() 返回一个文档满足指定的查询条件。如果有多个文档满足查询条件，则返回第一个文档
        User user = mongoTemplate.findOne(query, User.class,"users");
        return user;
    }

    @Override
    public String addUser(User user) {
        mongoTemplate.insert(user,"users");
        return "success";
    }

    @Override
    public String alterUser(User user) {
        Query query = Query.query(Criteria.where("name").is(user.getName()));
        Update update = new Update();
        update.set("name", user.getName());
        update.set("password", user.getPassword());
        //参数1:查询条件  参数2:修改  参数3:表名称（也可以是具体集合名）
        mongoTemplate.updateFirst(query, update, "users");
        return "success";
    }

    @Override
    public String removeUserByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        mongoTemplate.remove(query, User.class,"users");
        return "success";
    }
}
