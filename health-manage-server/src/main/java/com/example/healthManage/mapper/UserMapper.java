package com.example.healthManage.mapper;

import com.example.healthManage.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    void insert(User user);

    void updateByLoginId(User user);

    void deleteById(Integer id);

    User selectByLoginId(String loginId);

    User selectById(Integer id);
}
