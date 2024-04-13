package com.example.healthManage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Diet implements Serializable {

    private Integer id;

    private String loginId;

    private String dietDate;

    private String dietType;

    private String specificPlan;

    private String dietHeat;
}
