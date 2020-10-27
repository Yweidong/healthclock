package com.example.healthclock.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-27 15:05
 **/
@Entity
@Table(name = "illnes", schema = "operation", catalog = "")
public class IllnesEntity implements Serializable {
    private static final long serialVersionUID = -221052583780830077L;
    private Integer id;
    private String illness;
    private Integer type;
    private Integer parent=0;
    private Integer auth =0;

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
    @Column(name = "illness")
    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
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
    @Column(name = "parent")
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "auth")
    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "IllnesEntity{" +
                "id=" + id +
                ", illness='" + illness + '\'' +
                ", type=" + type +
                ", parent=" + parent +
                ", auth=" + auth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IllnesEntity that = (IllnesEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(illness, that.illness) &&
                Objects.equals(type, that.type) &&
                Objects.equals(parent, that.parent) &&
                Objects.equals(auth, that.auth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, illness, type, parent, auth);
    }
}
