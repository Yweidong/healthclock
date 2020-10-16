package com.example.healthclock.service.impl;

import com.example.healthclock.dao.HealthPunchDao;
import com.example.healthclock.dao.IsstartDao;
import com.example.healthclock.dao.StudentsDao;
import com.example.healthclock.entity.HealthPunchEntity;
import com.example.healthclock.entity.IsstartEntity;
import com.example.healthclock.entity.StudentsEntity;
import com.example.healthclock.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.healthclock.utils.TimeTransformationUtils.*;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-16 10:27
 **/
@Service
public class ClockServiceImpl implements ClockService {
    @Autowired
    HealthPunchDao healthPunchDao;
    @Autowired
    IsstartDao isstartDao;
    @Autowired
    StudentsDao studentsDao;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public HashMap<String, Object> dailyLimit(Integer stuId) {
        HashMap<String, Object> map = new HashMap<>();
        if((System.currentTimeMillis() / 1000)>DateToTimestmp(SysCurrTime()) && (System.currentTimeMillis() / 1000)<=SpecTimeToTimestmp(SysCurrTime(),"2:30:00")) {
            map.put("code",400);
            map.put("message","打卡时间未到");
            return map;
        }
        StudentsEntity studentsDaoOne = studentsDao.getOne(stuId);

        IsstartEntity isstartEntity = isstartDao.findByClassidAndSchoolId(studentsDaoOne.getOrganizeID(), studentsDaoOne.getSchoolId());
        if(isstartEntity ==null || isstartEntity.getHealthStart() == 0) {
            map.put("code",400);
            map.put("message","您所在的班级处于未启动状态,无法进行健康打卡");
            return map;
        }
        String redis_key = "clock:"+stuId;
        map.put("code",200);
        map.put("message","ok");
        if(redisTemplate.hasKey(redis_key) && redisTemplate.opsForValue().get(redis_key).equals(1)) {
            map.put("code",4000);
            map.put("message"," ");
        }else {

            HealthPunchEntity queryResult = healthPunchDao.defineQueryResult(stuId,
                    String.valueOf(DateToTimestmp(SysCurrTime())),
                    String.valueOf(DateToTimestmp(TomorrowDate()))
            );
            if(queryResult!=null) {
                map.put("code",400);
                if(queryResult.getIscheck() == 2) {
                    map.put("message","您孩子状态码已审核通过,请明天开始正常打卡");
                }else if(queryResult.getEpitype()!=1 && queryResult.getEpitype()!=5) {
                    map.put("message","您孩子状态码异常,请变更审核过后再来打卡");
                }else if(queryResult.getEpitype() == 1 && queryResult.getEpitype()!=5) {
                    map.put("message","当前孩子今天已健康打卡或已测过体温,请明天再来");
                }
            }
        }
        return map;
    }
}
