package com.fulin.service;

import com.fulin.pojo.User;

import java.util.List;

public interface UserService {

    public int addUser(User user);
    public int deleteUser(int uid);

    public List<User> getUser();

    public String getPasswordByUsername(String username);

    public String getTargetByUsername(String username);
}
