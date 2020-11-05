package com.example.healthclock.service;

import com.example.healthclock.entity.mongodb.RubbishEntity;

import java.util.List;

public interface RubbishService {
    void updateEntity(RubbishEntity rubbishEntity);
    List<RubbishEntity> queryByTitle(String title);
}
