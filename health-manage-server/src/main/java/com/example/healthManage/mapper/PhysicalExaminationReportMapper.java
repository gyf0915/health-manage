package com.example.healthManage.mapper;

import com.example.healthManage.entity.PhysicalExaminationReport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicalExaminationReportMapper {

    List<PhysicalExaminationReport> list(String loginId);
    void insert(PhysicalExaminationReport physicalExaminationReport);

    void update(PhysicalExaminationReport physicalExaminationReport);

    void deleteById(Integer id);

    PhysicalExaminationReport selectByLoginId(String loginId);

    PhysicalExaminationReport selectById(Integer id);
}
