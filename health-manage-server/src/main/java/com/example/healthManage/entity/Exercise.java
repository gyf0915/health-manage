package com.example.healthManage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Exercise implements Serializable {

    private Integer id;

    private String loginId;

    private String exerciseType;

    private String exerciseDate;

    private String duration;

    private String consumeHeat;
}
