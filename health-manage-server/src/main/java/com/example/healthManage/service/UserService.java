package com.example.healthManage.service;

import com.example.healthManage.entity.User;

public interface UserService {

    void insert(User user);

    User update(User user) throws Exception;

    void deleteByLoginId(String id) throws Exception;

    User detail(String loginId);

    User loginByWX(User user);
}
