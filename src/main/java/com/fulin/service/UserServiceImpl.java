package com.fulin.service;

import com.fulin.mapper.UserMapper;
import com.fulin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @Override
    public String getPasswordByUsername(String username) {
        return userMapper.getPasswordByUsername(username);
    }

    @Override
    public String getTargetByUsername(String username) {
        return userMapper.getTargetByUsername(username);
    }
}
