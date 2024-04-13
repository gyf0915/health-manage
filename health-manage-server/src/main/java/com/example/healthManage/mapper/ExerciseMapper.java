package com.example.healthManage.mapper;

import com.example.healthManage.entity.Exercise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseMapper {

    List<Exercise> list(String loginId);
    void insert(Exercise exercise);

    void update(Exercise exercise);

    void deleteById(Integer id);

    Exercise selectByLoginId(String loginId);

    Exercise selectById(Integer id);
}
