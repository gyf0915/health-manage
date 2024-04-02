package com.example.healthManage.service;

import com.example.healthManage.entity.User;

public interface UserService {

    void insert(User user);

    void update(User user) throws Exception;

    void deleteById(Integer id) throws Exception;

    User detail(String loginId);
}
