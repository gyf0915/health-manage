package com.example.healthManage.service;

import com.example.healthManage.dto.DietListDTO;
import com.example.healthManage.entity.Diet;
import com.example.healthManage.entity.Exercise;

import java.util.List;

public interface DietService {

    List<Diet> list(DietListDTO dietListDTO);
    void insert(Diet diet);

    void update(Diet diet) throws Exception;

    void deleteById(Integer id) throws Exception;

    Diet detailById(Integer id);
}
