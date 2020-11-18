package com.example.healthclock.service;

import com.example.healthclock.entity.mongodb.RubbishEntity;


import java.util.List;
import java.util.Set;

public interface RubbishService {
    void updateEntity(RubbishEntity rubbishEntity);
    List<RubbishEntity> queryByTitle(String title);//根据title来查询
    Set<String> queryByType(String type);//跟据type来查询

    void bulkInsertData();
}
