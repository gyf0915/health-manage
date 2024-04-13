package com.example.healthManage.service.impl;

import com.example.healthManage.dto.PEListDTO;
import com.example.healthManage.entity.PhysicalExaminationReport;
import com.example.healthManage.mapper.PhysicalExaminationReportMapper;
import com.example.healthManage.service.PhysicalExaminationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PhysicalExaminationReportServiceImpl implements PhysicalExaminationReportService {

    @Autowired
    private PhysicalExaminationReportMapper physicalExaminationReportMapper;

    @Override
    public List<PhysicalExaminationReport> list(PEListDTO peListDTO) {
        return physicalExaminationReportMapper.list(peListDTO.getLoginId());
    }

    @Override
    public void insert(PhysicalExaminationReport physicalExaminationReport) {
        physicalExaminationReportMapper.insert(physicalExaminationReport);
    }

    @Override
    public void update(PhysicalExaminationReport physicalExaminationReport) throws Exception {
        physicalExaminationReportMapper.update(physicalExaminationReport);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        physicalExaminationReportMapper.deleteById(id);
    }

    @Override
    public PhysicalExaminationReport detailById(Integer id) {
        return physicalExaminationReportMapper.selectById(id);
    }
}
