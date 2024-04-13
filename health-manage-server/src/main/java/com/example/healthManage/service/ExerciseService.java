package com.example.healthManage.service;


import com.example.healthManage.dto.ExerciseListDTO;
import com.example.healthManage.entity.Exercise;

import java.util.List;

public interface ExerciseService {

    List<Exercise> list(ExerciseListDTO exerciseListDTO);
    void insert(Exercise exercise);

    void update(Exercise exercise) throws Exception;

    void deleteById(Integer id) throws Exception;

    Exercise detailById(Integer id);
}
