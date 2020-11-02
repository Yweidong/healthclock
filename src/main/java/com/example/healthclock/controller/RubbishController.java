package com.example.healthclock.controller;

import com.example.healthclock.annotation.MyLogAnno;
import com.example.healthclock.annotation.ResObjectAnno;
import com.example.healthclock.common.Result;
import com.example.healthclock.common.ResultStatus;
import com.example.healthclock.entity.mongodb.RubbishEntity;
import com.example.healthclock.service.RubbishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 14:53
 **/
@RestController
@ResObjectAnno
@RequestMapping("/api/v1")
public class RubbishController {
    @Autowired
    RubbishService rubbishService;

    private static final RubbishEntity RubbishEntity = new RubbishEntity();

    @GetMapping("/rubbish")
    @MyLogAnno
    public Result getRubbishList() {

        rubbishService.updateEntity(RubbishEntity);

        return new Result(ResultStatus.SUCCESS,"操作成功");
    }
}
