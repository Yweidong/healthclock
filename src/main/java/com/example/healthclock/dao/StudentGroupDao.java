package com.example.healthclock.dao;

import com.example.healthclock.entity.StudentGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupDao extends JpaRepository<StudentGroupEntity,Integer> {
}
