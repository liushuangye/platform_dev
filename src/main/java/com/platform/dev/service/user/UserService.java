package com.platform.dev.service.user;

import com.platform.dev.entity.user.User;

public interface UserService {
    public User findUserByName(String name);
    public String addUser(User user);
    public String alterUser(User user);
    public String removeUserByName(String name);
}
