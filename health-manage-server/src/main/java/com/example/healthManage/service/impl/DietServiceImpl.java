package com.example.healthManage.service.impl;

import com.example.healthManage.dto.DietListDTO;
import com.example.healthManage.entity.Diet;
import com.example.healthManage.mapper.DietMapper;
import com.example.healthManage.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DietServiceImpl implements DietService {

    @Autowired
    private DietMapper dietMapper;

    @Override
    public List<Diet> list(DietListDTO dietListDTO) {
        return dietMapper.list(dietListDTO.getLoginId());
    }

    @Override
    public void insert(Diet diet) {
        dietMapper.insert(diet);
    }

    @Override
    public void update(Diet diet) throws Exception {
        dietMapper.update(diet);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        dietMapper.deleteById(id);
    }

    @Override
    public Diet detailById(Integer id) {
        return dietMapper.selectById(id);
    }
}
