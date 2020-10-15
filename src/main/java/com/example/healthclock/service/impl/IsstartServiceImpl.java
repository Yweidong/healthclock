package com.example.healthclock.service.impl;


import com.example.healthclock.dao.HealthPunchDao;
import com.example.healthclock.entity.HealthPunchEntity;
import com.example.healthclock.service.IsstartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 13:34
 **/
@Service

public class IsstartServiceImpl  implements IsstartService {
    @Autowired
    HealthPunchDao healthPunchDao;
    @Override
    public HealthPunchEntity list(Integer id) {
        return healthPunchDao.getOne(id);
    }
}
