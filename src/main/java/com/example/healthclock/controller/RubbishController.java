package com.example.healthclock.controller;

import com.example.healthclock.annotation.MyLogAnno;
import com.example.healthclock.annotation.ResObjectAnno;
import com.example.healthclock.common.Result;
import com.example.healthclock.common.ResultStatus;
import com.example.healthclock.common.RubbishType;
import com.example.healthclock.entity.mongodb.RubbishEntity;
import com.example.healthclock.service.RubbishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/search")
    @MyLogAnno
    public List<RubbishEntity> searchList(@RequestParam(value = "title") String title) {
        List<RubbishEntity> rubbishEntities = rubbishService.queryByTitle(title);
        return rubbishEntities;
    }

    @GetMapping("/searchType")
    @MyLogAnno
    public Set<String> searchTypeList(@RequestParam(value = "type") String type) {
        Set<String> strings = rubbishService.queryByType(type);
        return strings;

    }

    @PostMapping("/insert")
    @MyLogAnno
    public void bulkData() {


        rubbishService.bulkInsertData();

    }

}
