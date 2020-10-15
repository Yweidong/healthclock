package com.example.healthclock.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 13:23
 **/

@Entity
@Table(name = "isstart")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class IsstartEntity implements Serializable {
    private static final long serialVersionUID = -9203277492940211123L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer classid;

    @Column(name = "schoolId")

    private Integer schoolId;

    private Integer isstart;

    @Column(name = "healthStart")
    private Integer healthStart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getIsstart() {
        return isstart;
    }

    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    public Integer getHealthStart() {
        return healthStart;
    }

    public void setHealthStart(Integer healthStart) {
        this.healthStart = healthStart;
    }

    @Override
    public String toString() {
        return "IsstartEntity{" +
                "id=" + id +
                ", classid=" + classid +
                ", schoolId=" + schoolId +
                ", isstart=" + isstart +
                ", healthStart=" + healthStart +
                '}';
    }
}
