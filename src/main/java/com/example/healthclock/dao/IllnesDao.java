package com.example.healthclock.dao;

import com.example.healthclock.entity.IllnesEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-27 15:13
 **/
public interface IllnesDao extends JpaRepository<IllnesEntity,Integer> {
    IllnesEntity findByIllness(String illness);
    @Query(nativeQuery = true,value = "select * from illnes where id in :symIds order by type DESC limit 1")
    IllnesEntity findByIds(@Param("symIds") String[] symIds);

    @Query(nativeQuery = true,value = "select * from illnes where id in :symIds ")
    List<IllnesEntity> findByIdIn(String[] symIds);
}
