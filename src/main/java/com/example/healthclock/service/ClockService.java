package com.example.healthclock.service;

import com.example.healthclock.dao.HealthPunchDao;
import com.example.healthclock.dto.HealPunSubDto;

import java.util.HashMap;
import java.util.Map;

public interface ClockService {
    HashMap<String,Object> dailyLimit(Integer stuId);//每天打卡一次的限制
    HashMap<String,Object> healthpunchSub(HealPunSubDto healPunSubDto);//健康打卡提交
}
