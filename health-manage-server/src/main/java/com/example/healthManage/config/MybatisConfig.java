package com.example.healthManage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.healthManage.mapper")
public class MybatisConfig {

}
