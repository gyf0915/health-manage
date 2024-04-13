package com.example.healthManage.mapper;

import com.example.healthManage.entity.Diet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietMapper {

    List<Diet> list(String loginId);
    void insert(Diet diet);

    void update(Diet diet);

    void deleteById(Integer id);

    Diet selectByLoginId(String loginId);

    Diet selectById(Integer id);
}
