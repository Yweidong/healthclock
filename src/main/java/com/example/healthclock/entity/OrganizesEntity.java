package com.example.healthclock.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-26 17:32
 **/
@Entity
@Table(name = "organizes", schema = "operation")
public class OrganizesEntity implements Serializable {
    private static final long serialVersionUID = -2253197634487149046L;
    private Integer id;
    private String name;
    private String type;
    private Integer parent;
    private String schoolYear;
    private Integer importFlag = 0;
    private Integer userId;
    private Integer classtype;
    private Integer stage;
    private String sort;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "parent")
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "schoolYear")
    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Basic
    @Column(name = "importFlag")

    public Integer getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Integer importFlag) {
        this.importFlag = importFlag;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "classtype")
    public Integer getClasstype() {
        return classtype;
    }

    public void setClasstype(Integer classtype) {
        this.classtype = classtype;
    }

    @Basic
    @Column(name = "stage")
    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    @Basic
    @Column(name = "sort")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "OrganizesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parent=" + parent +
                ", schoolYear='" + schoolYear + '\'' +
                ", importFlag=" + importFlag +
                ", userId=" + userId +
                ", classtype=" + classtype +
                ", stage=" + stage +
                ", sort='" + sort + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizesEntity that = (OrganizesEntity) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                type.equals(that.type) &&
                parent.equals(that.parent) &&
                schoolYear.equals(that.schoolYear) &&
                importFlag.equals(that.importFlag) &&
                userId.equals(that.userId) &&
                classtype.equals(that.classtype) &&
                stage.equals(that.stage) &&
                sort.equals(that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, parent, schoolYear, importFlag, userId, classtype, stage, sort);
    }
}
