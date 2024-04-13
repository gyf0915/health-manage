package com.example.healthManage.service.impl;

import com.example.healthManage.dto.ExerciseListDTO;
import com.example.healthManage.entity.Exercise;
import com.example.healthManage.mapper.ExerciseMapper;
import com.example.healthManage.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {


    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public List<Exercise> list(ExerciseListDTO exerciseListDTO) {
        return exerciseMapper.list(exerciseListDTO.getLoginId());
    }

    @Override
    public void insert(Exercise exercise) {
        exerciseMapper.insert(exercise);
    }

    @Override
    public void update(Exercise exercise) throws Exception {
        exerciseMapper.update(exercise);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        exerciseMapper.deleteById(id);
    }

    @Override
    public Exercise detailById(Integer id) {
        return exerciseMapper.selectById(id);
    }
}
