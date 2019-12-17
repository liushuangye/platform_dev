package com.platform.dev.service.user.Impl;

import com.platform.dev.dao.user.Impl.UserDaoImpl;
import com.platform.dev.entity.user.User;
import com.platform.dev.service.user.UserService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDaoImpl userDaoImpl;

    @Override
    public User findUserByName(String name) {
        User user = userDaoImpl.findUserByName(name);
        return user;
    }

    @Override
    public String addUser(User user) {
        userDaoImpl.addUser(user);
        return "success";
    }

    @Override
    public String alterUser(User user) {
        userDaoImpl.alterUser(user);
        return "success";
    }

    @Override
    public String removeUserByName(String name) {
        userDaoImpl.removeUserByName(name);
        return "success";
    }
}
