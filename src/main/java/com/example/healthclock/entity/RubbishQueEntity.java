package com.example.healthclock.entity;

import com.alibaba.fastjson.JSONArray;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-11-14 09:47
 **/
@Entity
@Table(name = "rubbish_que", schema = "operation", catalog = "")
public class RubbishQueEntity {
    private Integer id;
    private Integer uId;
    private Integer type;
    private Integer nums;
    private String title;
    private String parsing;
    private String options;
    private String correct;
    private Integer diff;

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
    @Column(name = "uId")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "nums")
    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "parsing")
    public String getParsing() {
        return parsing;
    }

    public void setParsing(String parsing) {
        this.parsing = parsing;
    }

    @Basic
    @Column(name = "options")
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Basic
    @Column(name = "correct")
    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    @Basic
    @Column(name = "diff")
    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RubbishQueEntity that = (RubbishQueEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(nums, that.nums) &&
                Objects.equals(title, that.title) &&
                Objects.equals(parsing, that.parsing) &&
                Objects.equals(options, that.options) &&
                Objects.equals(correct, that.correct) &&
                Objects.equals(diff, that.diff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uId, type, nums, title, parsing, options, correct, diff);
    }

    @Override
    public String toString() {
        return "RubbishQueEntity{" +
                "id=" + id +
                ", uId=" + uId +
                ", type=" + type +
                ", nums=" + nums +
                ", title='" + title + '\'' +
                ", parsing='" + parsing + '\'' +
                ", options='" + options + '\'' +
                ", correct='" + correct + '\'' +
                ", diff=" + diff +
                '}';
    }
}
