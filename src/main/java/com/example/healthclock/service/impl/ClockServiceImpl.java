package com.example.healthclock.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import com.example.healthclock.common.HealthCodeName;
import com.example.healthclock.common.ResultStatus;
import com.example.healthclock.common.TimeCheck;
import com.example.healthclock.dao.*;
import com.example.healthclock.dto.HealPunSubDto;
import com.example.healthclock.entity.*;
import com.example.healthclock.exception.ResultException;
import com.example.healthclock.service.ClockService;
import com.example.healthclock.utils.JpaUtils;
import com.example.healthclock.utils.TimeTransformationUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
    private static final String HEALTH_CLOCK = "healthclock:";

    private static final String CLOCK = "clock:";

    private  Map<String,Object> objectMap = new HashMap<>();
    @Autowired
    HealthPunchDao healthPunchDao;
    @Autowired
    IsstartDao isstartDao;
    @Autowired
    StudentsDao studentsDao;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    OrganizesDao organizesDao;
    @Autowired
    IllnesDao illnesDao;
    @Autowired
    StudentGroupDao studentGroupDao;

    private HealthPunchEntity healthPunchEntity = new HealthPunchEntity();
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
        String early_warn_key = "earlyWarn:"+studentsDaoOne.getSchoolId();
        if(redisTemplate.hasKey(early_warn_key) && redisTemplate.opsForValue().get(early_warn_key).equals(2)) {
            map.put("code",400);
            map.put("message","家长暂无权限打卡,统一由班主任代打");
        }else if(redisTemplate.hasKey(redis_key) && redisTemplate.opsForValue().get(redis_key).equals(1)) {
            map.put("code",4000);
            map.put("message"," ");
        }else {
            map.put("code",200);
            map.put("message","ok");
            HealthPunchEntity queryResult = healthPunchDao.defineQueryResult(stuId,
                    String.valueOf(DateToTimestmp(SysCurrTime())),
                    String.valueOf(DateToTimestmp(TomorrowDate()))
            );
            if(queryResult!=null) {

                if(queryResult.getIscheck() == 2) {
                    map.put("code",400);
                    map.put("message","您孩子状态码已审核通过,请明天开始正常打卡");
                }else if(queryResult.getEpitype()!=1 && queryResult.getEpitype()!=5) {
                    map.put("code",400);
                    map.put("message","您孩子状态码异常,请变更审核过后再来打卡");
                }else if(queryResult.getEpitype() == 1 && queryResult.getEpitype()!=5) {
                    map.put("code",400);
                    map.put("message","当前孩子今天已健康打卡或已测过体温,请明天再来");
                }
            }
        }
        return map;
    }

    @Override
    @Transactional
    public HashMap<String, Object> healthpunchSub(HealPunSubDto healPunSubDto) {

        HashMap<String, Object> map = new HashMap<>();
        String stage = "";
        Integer record_id = 0;
        if(healPunSubDto.getStuId().equals(0)) {
            map.put("code",400);
            map.put("message","参数错误");
            return map;
        }
        long endTime = DateToTimestmp(SysCurrTime())+60*60*9+RandomUtil.randomInt(10,300);
        long clockTime = DateToTimestmp(SysCurrTime())+60*60*10+RandomUtil.randomInt(10,300);
//        long endTime = 1604109941;
//        long clockTime = 1604109941;
        StudentsEntity studentsEntity = studentsDao.getOne(healPunSubDto.getStuId());
        OrganizesEntity organizesEntity = organizesDao.getOne(studentsEntity.getOrganizeID());
        Integer quantum = new TimeCheck().getQuantum(SysCurrTimestmp(), organizesEntity.getStage());
        try{
            HealthPunchEntity result = healthPunchDao.otherQueryResult(
                    quantum,
                    studentsEntity.getId(),
                    String.valueOf(DateToTimestmp(SysCurrTime())),
                    String.valueOf(DateToTimestmp(TomorrowDate()))
            );


            if(healPunSubDto.getStatus().equals(1)) {
                stage = HealthCodeName.GREEN.getMessage();

                objectMap.put("stage",stage);
                if(result!=null) {
                    record_id = result.getId();
                    if(!(healPunSubDto.getColor().equals(0)) && !(healPunSubDto.getColor().equals(1)) && !(healPunSubDto.getColor().equals(5))) {
                        healthPunchEntity.setEpistated(1);
                        healthPunchEntity.setStaged(stage);
                        healthPunchEntity.setIllded(String.valueOf(illnesDao.findByIllness("身体正常").getId()));
                        healthPunchEntity.setIscheck(2);
                        healthPunchEntity.setUpdateTime(String.valueOf(
                                TimeTransformationUtils.getLocalStmp()));

                    }else {
                        healthPunchEntity.setEpitype(1);
                        healthPunchEntity.setEpidesc(String.valueOf(7));
                        healthPunchEntity.setStage(stage);
                        healthPunchEntity.setCreateTime(String.valueOf(
                                TimeTransformationUtils.getLocalStmp()));
                        healthPunchEntity.setIscheck(0);
                        healthPunchEntity.setRemark("");
                        healthPunchEntity.setUpdateTime("");
                    }
                    JpaUtils.copyNotNullProperties(healthPunchEntity,result);
                    healthPunchDao.saveAndFlush(result);


                }else {
                    healthPunchEntity.setStuid(healPunSubDto.getStuId());
                    healthPunchEntity.setEpitype(1);
                    healthPunchEntity.setEpidesc(String.valueOf(7));
                    healthPunchEntity.setStage(stage);
                    healthPunchEntity.setOrganizeID(studentsEntity.getOrganizeID());
                    healthPunchEntity.setSchoolId(studentsEntity.getSchoolId());
                    healthPunchEntity.setCreateTime(String.valueOf(
                            TimeTransformationUtils.getLocalStmp()));
                    healthPunchEntity.setQuantum(quantum);
                    record_id = healthPunchDao.saveAndFlush(healthPunchEntity).getId();

                }
                objectMap.put("color",1);
                objectMap.put("record_id",record_id);
                map.put("code",200);
                map.put("message","操作成功");

            }else {
                /**
                 *1.事假
                 *2。病假
                 */

                if(healPunSubDto.getType().equals(1)) {
                    stage = HealthCodeName.CYAN.getMessage();
                    String illness = illnesDao
                            .getOne(Integer.valueOf(healPunSubDto.getSymId()))
                            .getIllness();

                    objectMap.put("stage",stage);
                    objectMap.put("illness",illness);
                if(result!=null) {
                    record_id = result.getId();
                    healthPunchEntity.setEpitype(2);
                    healthPunchEntity.setEpidesc(healPunSubDto.getSymId());
                    healthPunchEntity.setStage(stage);
                    healthPunchEntity.setCreateTime(String.valueOf(
                            TimeTransformationUtils.getLocalStmp()));
                    healthPunchEntity.setRemark(healPunSubDto.getRemark());
                    healthPunchEntity.setIscheck(0);
                    JpaUtils.copyNotNullProperties(healthPunchEntity,result);
                    healthPunchDao.saveAndFlush(result);

                }else {
                    healthPunchEntity.setStuid(healPunSubDto.getStuId());
                    healthPunchEntity.setEpitype(2);
                    healthPunchEntity.setEpidesc(healPunSubDto.getSymId());
                    healthPunchEntity.setStage(stage);
                    healthPunchEntity.setOrganizeID(studentsEntity.getOrganizeID());
                    healthPunchEntity.setSchoolId(studentsEntity.getSchoolId());
                    healthPunchEntity.setCreateTime(String.valueOf(
                            TimeTransformationUtils.getLocalStmp()));
                    healthPunchEntity.setQuantum(quantum);
                    healthPunchEntity.setRemark(healPunSubDto.getRemark());
                   record_id = healthPunchDao.saveAndFlush(healthPunchEntity).getId();

                }
                    objectMap.put("code",2);
                    objectMap.put("record_id",record_id);
                    map.put("code",200);
                    map.put("message","操作成功");

                }else {
                    if("".equals(healPunSubDto.getSymptom())) {
                        map.put("code",400);
                        map.put("message","请选择病情");
                        return map;
                    }
                    String[] split = healPunSubDto.getSymptom().split(",");
                    Integer code = illnesDao.findByIds(split).getType();

                    if(code.equals(3)) {
                        stage = HealthCodeName.YELLOW.getMessage();
                    }else {
                        stage = HealthCodeName.RED.getMessage();
                    }
                    objectMap.put("stage",stage);
                    String collect = illnesDao.findByIdIn(split).stream().map(illnesEntity -> {
                        return illnesEntity.getIllness();
                    }).collect(Collectors.joining(","));

                    objectMap.put("illness",collect);
                    healthPunchEntity.setEpitype(code);
                    healthPunchEntity.setEpidesc(healPunSubDto.getSymptom());
                    healthPunchEntity.setStage(stage);
                    healthPunchEntity.setHosName(healPunSubDto.getHos_name());
                    healthPunchEntity.setCaseType(healPunSubDto.getCase_type());
                    healthPunchEntity.setCreateTime(String.valueOf(
                            TimeTransformationUtils.getLocalStmp()));
                    healthPunchEntity.setRemark(healPunSubDto.getRemark());
                if(result!=null) {
                    healthPunchEntity.setIscheck(0);
                    JpaUtils.copyNotNullProperties(healthPunchEntity,result);
                    healthPunchDao.saveAndFlush(result);

                }else {
                    healthPunchEntity.setOrganizeID(studentsEntity.getOrganizeID());
                    healthPunchEntity.setQuantum(quantum);
                    healthPunchEntity.setStuid(healPunSubDto.getStuId());
                    healthPunchEntity.setSchoolId(studentsEntity.getSchoolId());
                    record_id = healthPunchDao.saveAndFlush(healthPunchEntity).getId();

                }
                    objectMap.put("color",code);
                    objectMap.put("record_id",record_id);
                }

                StudentGroupEntity sgresult = studentGroupDao.findByStuidAndCreateTimeBetween(healPunSubDto.getStuId(),
                        String.valueOf(DateToTimestmp(SysCurrTime())),
                        String.valueOf(DateToTimestmp(TomorrowDate())));
                if(sgresult!=null) {
                    StudentGroupEntity studentGroupEntity = new StudentGroupEntity();
                    studentGroupEntity.setStatus(3);
                    studentGroupEntity.setUpdateTime(String.valueOf(
                            TimeTransformationUtils.getLocalStmp()));
                    JpaUtils.copyNotNullProperties(studentGroupEntity,sgresult);
                    studentGroupDao.saveAndFlush(sgresult);
                }
                map.put("code",200);
                map.put("message","操作成功");
            }

            if(endTime>=TimeTransformationUtils.getLocalStmp()) {
                String redis_key = HEALTH_CLOCK+healPunSubDto.getStuId();
               redisTemplate.opsForValue().set(redis_key,objectMap,endTime-TimeTransformationUtils.getLocalStmp(), TimeUnit.SECONDS);
            }
            if(clockTime>=TimeTransformationUtils.getLocalStmp()) {
                String redis_key = CLOCK+healPunSubDto.getStuId();
                redisTemplate.opsForValue().increment(redis_key);
                redisTemplate.expire(redis_key,clockTime-TimeTransformationUtils.getLocalStmp(),TimeUnit.SECONDS);
            }

        }catch(Exception e){
            map.put("code",400);
            map.put("message","操作失败");
        }
        return map;
    }

}
