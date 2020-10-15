package com.example.healthclock.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-15 16:19
 **/
@Entity
@Table(name = "HealthPunch")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class HealthPunchEntity implements Serializable {
    private static final long serialVersionUID = -3437715213537704594L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer stuid;

    private Integer epitype;

    private String epidesc;

    private String stage;

    @Column(name = "organizeID")
    private Integer organizeID;

    @Column(name = "schoolId")
    private Integer schoolId;

    private String remark;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "updateTime")
    private String updateTime;

    private Integer checkerid;

    private String reason;

    private String prove;

    private Integer ischeck;

    private Integer quantum;

    private Integer checkon;

    private Integer epistated;

    @Column(name = "applyAgree")
    private Integer applyAgree;

    private String illded;

    private String staged;

    private String counterreason;

    @Column(name = "applyTime")
    private String applyTime;

    @Column(name = "applyUserId")
    private Integer applyUserId;

    @Column(name = "hos_name")
    private String hosName;

    @Column(name = "case_type")
    private Integer caseType;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getEpitype() {
        return epitype;
    }

    public void setEpitype(Integer epitype) {
        this.epitype = epitype;
    }

    public String getEpidesc() {
        return epidesc;
    }

    public void setEpidesc(String epidesc) {
        this.epidesc = epidesc;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCheckerid() {
        return checkerid;
    }

    public void setCheckerid(Integer checkerid) {
        this.checkerid = checkerid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProve() {
        return prove;
    }

    public void setProve(String prove) {
        this.prove = prove;
    }

    public Integer getIscheck() {
        return ischeck;
    }

    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    public Integer getQuantum() {
        return quantum;
    }

    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    public Integer getCheckon() {
        return checkon;
    }

    public void setCheckon(Integer checkon) {
        this.checkon = checkon;
    }

    public Integer getEpistated() {
        return epistated;
    }

    public void setEpistated(Integer epistated) {
        this.epistated = epistated;
    }

    public Integer getApplyAgree() {
        return applyAgree;
    }

    public void setApplyAgree(Integer applyAgree) {
        this.applyAgree = applyAgree;
    }

    public String getIllded() {
        return illded;
    }

    public void setIllded(String illded) {
        this.illded = illded;
    }

    public String getStaged() {
        return staged;
    }

    public void setStaged(String staged) {
        this.staged = staged;
    }

    public String getCounterreason() {
        return counterreason;
    }

    public void setCounterreason(String counterreason) {
        this.counterreason = counterreason;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    @Override
    public String toString() {
        return "HealthPunchEntity{" +
                "id=" + id +
                ", stuid=" + stuid +
                ", epitype=" + epitype +
                ", epidesc='" + epidesc + '\'' +
                ", stage='" + stage + '\'' +
                ", organizeID=" + organizeID +
                ", schoolId=" + schoolId +
                ", remark='" + remark + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", checkerid=" + checkerid +
                ", reason='" + reason + '\'' +
                ", prove='" + prove + '\'' +
                ", ischeck=" + ischeck +
                ", quantum=" + quantum +
                ", checkon=" + checkon +
                ", epistated=" + epistated +
                ", applyAgree=" + applyAgree +
                ", illded='" + illded + '\'' +
                ", staged='" + staged + '\'' +
                ", counterreason='" + counterreason + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", applyUserId=" + applyUserId +
                ", hosName='" + hosName + '\'' +
                ", caseType=" + caseType +
                '}';
    }
}
