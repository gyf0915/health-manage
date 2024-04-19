package com.example.healthManage.service.impl;

import com.example.healthManage.entity.User;
import com.example.healthManage.mapper.UserMapper;
import com.example.healthManage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public User update(User user) throws Exception {
        String loginId = user.getLoginId();
        User existUser = userMapper.selectByLoginId(loginId);
        if (existUser == null) {
            throw new Exception("用户不存在");
        }
        userMapper.updateByLoginId(user);
        return user;
    }

    @Override
    public void deleteById(String id) throws Exception {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new Exception("用户不存在");
        }
        userMapper.deleteById(id);
    }

    @Override
    public User detail(String loginId) {
        return userMapper.selectByLoginId(loginId);
    }

    @Override
    public User loginByWX(User user) {
        User existUser = userMapper.selectByLoginId(user.getLoginId());
        if (existUser == null) {
            User newUser = new User();
            newUser.setLoginId(user.getLoginId());
            newUser.setUsername(user.getLoginId());
            newUser.setCreateTime(new Date());
            newUser.setUpdateTime(new Date());
            newUser.setPassword("1234");
            userMapper.insert(newUser);
            user = newUser;
        } else {
            user = existUser;
        }
        return user;
    }
}
