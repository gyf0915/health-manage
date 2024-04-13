package com.example.healthManage.controller;

import com.example.healthManage.dto.ExerciseListDTO;
import com.example.healthManage.dto.PEListDTO;
import com.example.healthManage.dto.RestResult;
import com.example.healthManage.entity.Exercise;
import com.example.healthManage.entity.PhysicalExaminationReport;
import com.example.healthManage.service.ExerciseService;
import com.example.healthManage.service.PhysicalExaminationReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/phyExamReport")
public class PhysicalExaminationReportController {

    @Autowired
    private PhysicalExaminationReportService physicalExaminationReportService;

    @PostMapping("/list")
    public RestResult<?> list(@RequestBody PEListDTO peListDTO) {
        log.info("请求锻炼信息列表：{}", peListDTO);
        return RestResult.T(physicalExaminationReportService.list(peListDTO));
    }

    @PostMapping("/insert")
    public RestResult<?> insert(@RequestBody PhysicalExaminationReport physicalExaminationReport) {
        log.info("新增体检报告：{}", physicalExaminationReport);
        physicalExaminationReportService.insert(physicalExaminationReport);
        return RestResult.T();
    }

    @PostMapping("/update")
    public RestResult<?> update(@RequestBody PhysicalExaminationReport physicalExaminationReport) throws Exception {
        log.info("新增体检报告：{}", physicalExaminationReport);
        physicalExaminationReportService.update(physicalExaminationReport);
        return RestResult.T();
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<?> delete(@PathVariable Integer id) throws Exception {
        log.info("删除体检报告");
        physicalExaminationReportService.deleteById(id);
        return RestResult.T();
    }

    @GetMapping("/detail/{id}")
    public RestResult<?> detailById(@PathVariable Integer id) {
        log.info("获取体检报告，id：{}", id);
        return RestResult.T(physicalExaminationReportService.detailById(id));
    }
}
