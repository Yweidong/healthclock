package com.example.healthclock.service;

import java.util.HashMap;
import java.util.Map;

public interface ClockService {
    HashMap<String,Object> dailyLimit(Integer stuId);//每天打卡一次的限制
}
