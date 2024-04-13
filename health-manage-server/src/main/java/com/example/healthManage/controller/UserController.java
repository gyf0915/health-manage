package com.example.healthManage.controller;

import com.example.healthManage.dto.RestResult;
import com.example.healthManage.entity.User;
import com.example.healthManage.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public RestResult<?> insert(@RequestBody User user) {
        log.info("新增用户：{}", user);
        userService.insert(user);
        return RestResult.T();
    }

    @PostMapping("/update")
    public RestResult<?> update(@RequestBody User user) throws Exception {
        log.info("新增用户：{}", user);
        userService.update(user);
        return RestResult.T();
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<?> delete(@PathVariable Integer id) throws Exception {
        log.info("删除用户");
        userService.deleteById(id);
        return RestResult.T();
    }

    @GetMapping("/detail/{loginId}")
    public RestResult<?> insert(@PathVariable String loginId) {
        log.info("获取用户信息，loginId为：{}", loginId);
        return RestResult.T(userService.detail(loginId));
    }

    @PostMapping("/loginByWX")
    public RestResult<?> loginByWX(@PathVariable String loginId) {
        log.info("获取用户信息，loginId为：{}", loginId);
        return RestResult.T(userService.detail(loginId));
    }
}
