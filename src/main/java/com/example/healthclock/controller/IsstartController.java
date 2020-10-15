package com.example.healthclock.controller;

import com.example.healthclock.common.Result;
import com.example.healthclock.entity.HealthPunchEntity;
import com.example.healthclock.service.IsstartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 15:45
 **/
@RestController
@RequestMapping("/api/v1")
public class IsstartController {

    @Autowired
    IsstartService isstartService;
    @GetMapping("/test")
    public Result<HealthPunchEntity> findAll() {
        HealthPunchEntity list = isstartService.list(12740);
        return Result.success(list);
    }
}
