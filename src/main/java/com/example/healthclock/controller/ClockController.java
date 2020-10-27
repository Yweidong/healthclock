package com.example.healthclock.controller;

import com.example.healthclock.annotation.MyLogAnno;
import com.example.healthclock.annotation.ResObjectAnno;
import com.example.healthclock.common.Result;
import com.example.healthclock.common.ResultStatus;
import com.example.healthclock.dao.HealthPunchDao;
import com.example.healthclock.dto.HealPunSubDto;
import com.example.healthclock.exception.ResultException;
import com.example.healthclock.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-16 14:07
 **/
@RestController
@ResObjectAnno
@RequestMapping("/api/v1")
public class ClockController {
    @Autowired
    ClockService clockService;





    @GetMapping("/dailyLimit")
    @MyLogAnno()
    public Result dailyLimit(@RequestParam(name = "stuId") Integer stuId) {
        HashMap<String, Object> map = clockService.dailyLimit(stuId);
        if(map.get("code").equals(400)) {
            throw new ResultException(ResultStatus.BAD_REQUEST, (String) map.get("message"));
        }else if(map.get("code").equals(200)) {
            return new Result(ResultStatus.SUCCESS,map.get("message"));
        }else if(map.get("code").equals(4000)){
            throw new ResultException(ResultStatus.SPECIAL_CODE, "");
        }else {
            throw new ResultException(ResultStatus.BAD_REQUEST,"当前打卡人数过多，请稍后再试");
        }

    }
    @PostMapping("/healthpunchSub")
    @MyLogAnno
    public Result healthpunchSub(HealPunSubDto healPunSubDto) {
        HashMap<String, Object> map = clockService.healthpunchSub(healPunSubDto);
        System.out.println(healPunSubDto);
        return null;
    }
}
