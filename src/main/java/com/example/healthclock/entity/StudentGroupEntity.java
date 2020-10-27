package com.example.healthclock.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-27 15:09
 **/
@Entity
@Table(name = "studentGroup", schema = "operation", catalog = "")
public class StudentGroupEntity implements Serializable {
    private static final long serialVersionUID = 6099144446557472645L;
    private Integer id;
    private Integer stuid;
    private Integer groupid;
    private Integer schoolid;
    private Integer organizeId;
    private String createTime;
    private Integer status = 1;
    private Integer sign = 0;
    private String updateTime;
    private Integer schoolYearId;
    private Integer state = 0;
    private String time1;
    private String time2;
    private String time3;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stuid")
    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    @Basic
    @Column(name = "groupid")
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Basic
    @Column(name = "schoolid")
    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    @Basic
    @Column(name = "organizeId")
    public Integer getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    @Basic
    @Column(name = "createTime")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "sign")
    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "updateTime")
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "schoolYearId")
    public Integer getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(Integer schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "time1")
    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    @Basic
    @Column(name = "time2")
    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    @Basic
    @Column(name = "time3")
    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroupEntity that = (StudentGroupEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(stuid, that.stuid) &&
                Objects.equals(groupid, that.groupid) &&
                Objects.equals(schoolid, that.schoolid) &&
                Objects.equals(organizeId, that.organizeId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(sign, that.sign) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(schoolYearId, that.schoolYearId) &&
                Objects.equals(state, that.state) &&
                Objects.equals(time1, that.time1) &&
                Objects.equals(time2, that.time2) &&
                Objects.equals(time3, that.time3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuid, groupid, schoolid, organizeId, createTime, status, sign, updateTime, schoolYearId, state, time1, time2, time3);
    }
}
