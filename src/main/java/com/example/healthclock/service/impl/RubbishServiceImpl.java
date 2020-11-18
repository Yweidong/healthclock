package com.example.healthclock.service.impl;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.healthclock.common.RubbishType;
import com.example.healthclock.dao.RubbishQueDao;
import com.example.healthclock.entity.RubbishQueEntity;
import com.example.healthclock.entity.mongodb.RubbishEntity;
import com.example.healthclock.provider.QiNiuProvider;
import com.example.healthclock.service.RubbishService;
import com.example.healthclock.utils.FileNameUtils;

import com.google.gson.JsonArray;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 14:50
 *
 *
 *
 * Query query = new Query();
 * 		query.fields().include("path"); //包含该字段
 * 		query.fields().exclude("salary");//不包含该字段
 **/
@Service
public class RubbishServiceImpl implements RubbishService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    QiNiuProvider qiNiuProvider;

    @Autowired
    RubbishQueDao rubbishQueDao;

    @Value("${oss.qiniu.domain}")
    private String domain;
    @Override
    public void updateEntity(RubbishEntity rubbishEntity) {
        List<? extends RubbishEntity> list = mongoTemplate.findAll(rubbishEntity.getClass());
        Update update = new Update();
        list.forEach(s->{
            Query query = new Query(Criteria.where("_id").is(s.get_id()));
            try {
                DefaultPutRet upload = qiNiuProvider.upload(s.getImgUrl(),
                                    FileNameUtils.getRandomImgName(s.getImgUrl()));
                update.set("imgUrl",domain+"/"+upload.key);
                mongoTemplate.updateFirst(query,update,rubbishEntity.getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public List<RubbishEntity> queryByTitle(String title) {
        Pattern pattern = Pattern.compile("^.*" + title + ".*$", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("title").regex(pattern));
        List<RubbishEntity> rubbishEntities = mongoTemplate.find(query, RubbishEntity.class);
        return rubbishEntities;
    }

    @Override
    public Set<String> queryByType(String type) {
        Set<String> objects = new HashSet<>();
        Query query = new Query();


        query.addCriteria(Criteria.where("type").is(type));

        List<RubbishEntity> list = mongoTemplate.find(query, RubbishEntity.class);
        if(list!=null) {
            list.forEach(s->{
                objects.add(s.getTitle());
            });
        }

        return objects;
    }

    @Override
    public void bulkInsertData() {
        List<RubbishEntity> list = mongoTemplate.findAll(RubbishEntity.class);
        HashMap<String, String> map = new HashMap<>();

        list.forEach(s->{
            map.put(s.getTitle(),s.getType());
            if(s.getList()!=null) {
                s.getList().forEach(ss->{
                    map.put(ss.toString(),s.getType());
                });
            }

        });
        List<HashMap<String,String>> list1 = new ArrayList<>(4);
        HashMap<String, String> map1 = null;
        String option;
        for (int i = 0; i < 4; i++) {
            map1 = new HashMap<>();
            option = String.valueOf((char) (65+i));

            map1.put("prefix",option);

            map1.put("content", RubbishType.getMessage(option));
            list1.add(i,map1);

        }
        final RubbishQueEntity[] rubbishQueEntity = new RubbishQueEntity[1];

//
        map.forEach((s, s2) -> {

            if(RubbishType.getOption(s2) !=null) {
                rubbishQueEntity[0] = new RubbishQueEntity();
                rubbishQueEntity[0].setuId(1);
                rubbishQueEntity[0].setType(1);
                rubbishQueEntity[0].setNums(4);
                rubbishQueEntity[0].setTitle(s+" 属于哪种分类()");
                rubbishQueEntity[0].setParsing("测试");
                rubbishQueEntity[0].setDiff(2);
                rubbishQueEntity[0].setCorrect(RubbishType.getOption(s2));

                rubbishQueEntity[0].setOptions(String.valueOf(JSONArray.parseArray(JSON.toJSONString(list1))));
                System.out.println(rubbishQueEntity[0]);
                Integer id = rubbishQueDao.saveAndFlush(rubbishQueEntity[0]).getId();
                System.out.println(id);
            }


        });
    }
}
