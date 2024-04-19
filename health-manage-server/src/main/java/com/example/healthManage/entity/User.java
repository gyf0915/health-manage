package com.example.healthManage.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Integer id;

    private String loginId;

    private String username;

    private String password;

    private String email;

    private String height;

    private String weight;

    private String age;

    private String sex;

    private String userLevel;

    private Date createTime;

    private Date updateTime;
}
