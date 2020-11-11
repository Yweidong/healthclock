package com.example.healthclock.entity.mongodb;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * @program: healthclock
 * @description: 垃圾分类
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 14:38
 **/
@Document(collection = "rubbish")
public class RubbishEntity implements Serializable {
    @Id
    private ObjectId _id;
    private String title;
    private String type;
    private String href;
    private List list;
    @Field("imgUrl")
    private String imgUrl;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "RubbishEntity{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", href='" + href + '\'' +
                ", list=" + list +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
