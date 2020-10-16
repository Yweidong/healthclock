package com.example.healthclock.controller;

import com.example.healthclock.annotation.ResObjectAnno;
import com.example.healthclock.common.ResultStatus;
import com.example.healthclock.exception.ResultException;
import com.example.healthclock.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-16 14:07
 **/
@RestController
@ResObjectAnno
public class ClockController {
    @Autowired
    ClockService clockService;

    @GetMapping("/dailyLimit")
    public HashMap<String,Object> dailyLimit(@RequestParam(name = "stuId") Integer stuId) {
        HashMap<String, Object> map = clockService.dailyLimit(stuId);
        if(map.get("code").equals(400)) {
            throw new ResultException(ResultStatus.BAD_REQUEST, (String) map.get("message"));
        }else if(map.get("code").equals(200)) {
            return null;
        }else if(map.get("code").equals(4000)){
            throw new ResultException(ResultStatus.SPECIAL_CODE, "");
        }else {
            throw new ResultException(ResultStatus.INTERNAL_SERVER_ERROR,"");
        }

    }
}
