package com.fulin.mapper;

import com.fulin.pojo.User;

import java.util.List;

public interface UserMapper {

    public int addUser(User user);
    public int deleteUser(int uid);

    public List<User> getUser();

    public String getPasswordByUsername(String username);

    public String getTargetByUsername(String username);

}
