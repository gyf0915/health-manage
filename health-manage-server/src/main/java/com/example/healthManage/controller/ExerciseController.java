package com.example.healthManage.controller;

import com.example.healthManage.dto.ExerciseListDTO;
import com.example.healthManage.dto.RestResult;
import com.example.healthManage.entity.Exercise;
import com.example.healthManage.entity.User;
import com.example.healthManage.service.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/list")
    public RestResult<?> list(@RequestBody ExerciseListDTO exerciseListDTO) {
        log.info("请求锻炼信息列表：{}", exerciseListDTO);
        return RestResult.T(exerciseService.list(exerciseListDTO));
    }

    @PostMapping("/insert")
    public RestResult<?> insert(@RequestBody Exercise exercise) {
        log.info("新增锻炼信息：{}", exercise);
        exerciseService.insert(exercise);
        return RestResult.T();
    }

    @PostMapping("/update")
    public RestResult<?> update(@RequestBody Exercise exercise) throws Exception {
        log.info("新增锻炼信息：{}", exercise);
        exerciseService.update(exercise);
        return RestResult.T();
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<?> delete(@PathVariable Integer id) throws Exception {
        log.info("删除锻炼信息");
        exerciseService.deleteById(id);
        return RestResult.T();
    }

    @GetMapping("/detail/{id}")
    public RestResult<?> detailById(@PathVariable Integer id) {
        log.info("获取锻炼信息，loginId为：{}", id);
        return RestResult.T(exerciseService.detailById(id));
    }
}
