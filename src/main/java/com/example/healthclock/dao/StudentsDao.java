package com.example.healthclock.dao;


import com.example.healthclock.entity.IsstartEntity;
import com.example.healthclock.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 13:32
 **/

public interface StudentsDao extends JpaRepository<StudentsEntity,Integer> {
}
