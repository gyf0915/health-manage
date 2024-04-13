package com.example.healthManage.controller;

import com.example.healthManage.dto.DietListDTO;
import com.example.healthManage.dto.ExerciseListDTO;
import com.example.healthManage.dto.RestResult;
import com.example.healthManage.entity.Diet;
import com.example.healthManage.entity.User;
import com.example.healthManage.service.DietService;
import com.example.healthManage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/diet")
public class DietController {

    @Autowired
    private DietService dietService;
    @PostMapping("/list")
    public RestResult<?> list(@RequestBody DietListDTO dietListDTO) {
        log.info("请求饮食列表：{}", dietListDTO);
        return RestResult.T(dietService.list(dietListDTO));
    }
    @PostMapping("/insert")
    public RestResult<?> insert(@RequestBody Diet diet) {
        log.info("新增饮食：{}", diet);
        dietService.insert(diet);
        return RestResult.T();
    }

    @PostMapping("/update")
    public RestResult<?> update(@RequestBody Diet diet) throws Exception {
        log.info("新增饮食：{}", diet);
        dietService.update(diet);
        return RestResult.T();
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<?> delete(@PathVariable Integer id) throws Exception {
        log.info("删除饮食");
        dietService.deleteById(id);
        return RestResult.T();
    }

    @GetMapping("/detail/{id}")
    public RestResult<?> detailById(@PathVariable Integer id) {
        log.info("获取饮食信息，id为：{}", id);
        return RestResult.T(dietService.detailById(id));
    }
}
