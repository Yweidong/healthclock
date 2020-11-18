package com.example.healthclock.dao;

import com.example.healthclock.entity.OrganizesEntity;
import com.example.healthclock.entity.RubbishQueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubbishQueDao extends JpaRepository<RubbishQueEntity,Integer> {
}
