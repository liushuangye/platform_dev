package com.platform.dev.dao.user;

import com.platform.dev.entity.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findUserByName(String name);
    public String addUser(User user);
    public String alterUser(User user);
    public String removeUserByName(String name);
}
