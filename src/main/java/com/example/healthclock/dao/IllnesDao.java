package com.example.healthclock.dao;

import com.example.healthclock.entity.IllnesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-27 15:13
 **/
public interface IllnesDao extends JpaRepository<IllnesEntity,Integer> {
}
