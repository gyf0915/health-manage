package com.example.healthManage.service;


import com.example.healthManage.dto.PEListDTO;
import com.example.healthManage.entity.PhysicalExaminationReport;

import java.util.List;

public interface PhysicalExaminationReportService {

    List<PhysicalExaminationReport> list(PEListDTO peListDTO);
    void insert(PhysicalExaminationReport physicalExaminationReport);

    void update(PhysicalExaminationReport physicalExaminationReport) throws Exception;

    void deleteById(Integer id) throws Exception;

    PhysicalExaminationReport detailById(Integer id);
}
