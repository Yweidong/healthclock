package com.example.healthclock.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 16:09
 **/
@Entity
@Table(name = "students")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class StudentsEntity implements Serializable {
    private static final long serialVersionUID = -4794487214020378545L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone;

    @Column(name = "studentNo")
    private String studentNo;

    private Integer grade;

    private String sex;

    @Column(name = "avatarUrl")
    private String avatarUrl;

    private String address;

    private String source;

    private String icd;

    @Column(name="organizeID")
    private Integer organizeID;

    @Column(name="schoolId")
    private Integer schoolId;

    private String national;

    @Column(name="importFlag")
    private Integer importFlag;

    private String ic;

    private String abbreviations;

    private Integer oldclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIcd() {
        return icd;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public Integer getOrganizeID() {
        return organizeID;
    }

    public void setOrganizeID(Integer organizeID) {
        this.organizeID = organizeID;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public Integer getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Integer importFlag) {
        this.importFlag = importFlag;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(String abbreviations) {
        this.abbreviations = abbreviations;
    }

    public Integer getOldclass() {
        return oldclass;
    }

    public void setOldclass(Integer oldclass) {
        this.oldclass = oldclass;
    }

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", grade=" + grade +
                ", sex='" + sex + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", address='" + address + '\'' +
                ", source='" + source + '\'' +
                ", icd='" + icd + '\'' +
                ", organizeID=" + organizeID +
                ", schoolId=" + schoolId +
                ", national='" + national + '\'' +
                ", importFlag=" + importFlag +
                ", ic='" + ic + '\'' +
                ", abbreviations='" + abbreviations + '\'' +
                ", oldclass=" + oldclass +
                '}';
    }
}
