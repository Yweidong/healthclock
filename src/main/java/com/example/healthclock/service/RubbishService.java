package com.example.healthclock.service;

import com.example.healthclock.entity.mongodb.RubbishEntity;


import java.util.List;
import java.util.Set;

public interface RubbishService {
    void updateEntity(RubbishEntity rubbishEntity);
    List<RubbishEntity> queryByTitle(String title);
    Set<String> queryByType(String type);

}
