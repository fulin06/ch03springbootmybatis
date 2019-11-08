package com.fulin;


import com.fulin.mapper.UserMapper;
import com.fulin.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PageHelperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test(){

        PageHelper.startPage(0,2);
        List<User> userList = userMapper.getUser();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);

        for(User user:userList){
            System.out.println(user);
        }
        System.out.println(userPageInfo);
    }
}
