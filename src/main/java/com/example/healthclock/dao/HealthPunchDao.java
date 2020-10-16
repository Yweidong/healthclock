package com.example.healthclock.dao;


import com.example.healthclock.entity.HealthPunchEntity;
import com.example.healthclock.entity.IsstartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 13:32
 **/

public interface HealthPunchDao extends JpaRepository<HealthPunchEntity,Integer> {
    @Query(nativeQuery = true,value = "select * from HealthPunch where stuid = :stuId and createTime> :ystd and createTime< :today order by quantum")
    HealthPunchEntity defineQueryResult(@Param("stuId") Integer stuId, @Param("ystd") String ystd,@Param("today") String today);
}
