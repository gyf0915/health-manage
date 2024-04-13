package com.example.healthManage.entity;

import lombok.Data;

@Data
public class PhysicalExaminationReport {

    private Integer id;

    private String loginId;

    private String reportContent;

    private String reportDate;

    private String healthAnalysis;

    private String suggestion;
}
