package com.example.healthclock.dao;


import com.example.healthclock.entity.HealthPunchEntity;
import com.example.healthclock.entity.IsstartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Query(nativeQuery = true,value = "select * from HealthPunch where stuid = :stuId and createTime> :ystd and createTime< :today order by quantum DESC limit 1")
    HealthPunchEntity defineQueryResult(@Param("stuId") Integer stuId, @Param("ystd") String ystd,@Param("today") String today);


    @Query(nativeQuery = true,value = "select * from HealthPunch where quantum =:quantum and stuid = :stuId and createTime> :ystd and createTime< :today order by createTime DESC limit 1")
    HealthPunchEntity otherQueryResult(@Param("quantum") Integer quantum,@Param("stuId") Integer stuId,@Param("ystd") String ystd,@Param("today") String today);

    /**
     * @Modifying   更新和删除必须加上这个注解
     *
     */
    @Query(value = "update HealthPunchEntity SET " +
            "epistated=:epistated," +
            "staged=:staged," +
            "illded=:illded," +
            "ischeck=:ischeck," +
            "updateTime=:updateTime " +
            "where id=:id")
    @Modifying
    void updateNormal(
            @Param("epistated") Integer epistated,
            @Param("staged") String staged,
            @Param("illded") String illded,
            @Param("ischeck") Integer ischeck,
            @Param("updateTime") String updateTime,
            @Param("id") Integer id
                      );


    @Query(value = "update HealthPunchEntity set " +
            "epitype=:epitype," +
            "epidesc=:epidesc," +
            "stage=:stage," +
            "createTime=:createTime," +
            "ischeck=:ischeck," +
            "remark=:remark," +
            "updateTime=:updateTime," +
            "hosName=:hosName," +
            "caseType=:caseType "+
            "where id=:id")
    @Modifying
    void updateOtherNormal(
            @Param("epitype") Integer epitype,
            @Param("epidesc") String epidesc,
            @Param("stage") String stage,
            @Param("createTime") String createTime,
            @Param("ischeck") Integer ischeck,
            @Param("remark") String remark,
            @Param("updateTime") String updateTime,
            @Param("hosName") String hosName,
            @Param("caseType") Integer caseType,
            @Param("id") Integer id
    );
}
