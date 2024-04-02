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

    private Date createTime;

    private Date updateTime;
}
