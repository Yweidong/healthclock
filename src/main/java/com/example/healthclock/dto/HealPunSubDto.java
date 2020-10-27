package com.example.healthclock.dto;

/**
 * @program: healthclock
 * @description:   健康打卡请求数据成bean对象
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-27 15:41
 **/
public class HealPunSubDto {
    private Integer stuId;

    private Integer status;

    private Integer flag=0;

    private String symId="";

    private String remark="";

    private String symptom="";

    private String hos_name="";

    private Integer case_type=0;

    private Integer type = 0;

    private Integer color = 0;

    public HealPunSubDto() {
    }

    public HealPunSubDto(Integer stuId, Integer status, Integer flag, String symId, String remark, String symptom, String hos_name, Integer case_type, Integer type, Integer color) {
        this.stuId = stuId;
        this.status = status;
        this.flag = flag;
        this.symId = symId;
        this.remark = remark;
        this.symptom = symptom;
        this.hos_name = hos_name;
        this.case_type = case_type;
        this.type = type;
        this.color = color;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSymId() {
        return symId;
    }

    public void setSymId(String symId) {
        this.symId = symId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getHos_name() {
        return hos_name;
    }

    public void setHos_name(String hos_name) {
        this.hos_name = hos_name;
    }

    public Integer getCase_type() {
        return case_type;
    }

    public void setCase_type(Integer case_type) {
        this.case_type = case_type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "HealPunSubDto{" +
                "stuId=" + stuId +
                ", status=" + status +
                ", flag=" + flag +
                ", symId='" + symId + '\'' +
                ", remark='" + remark + '\'' +
                ", symptom='" + symptom + '\'' +
                ", hos_name='" + hos_name + '\'' +
                ", case_type=" + case_type +
                ", type=" + type +
                ", color=" + color +
                '}';
    }
}
