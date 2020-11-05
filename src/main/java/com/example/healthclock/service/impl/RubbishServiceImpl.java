package com.example.healthclock.service.impl;


import com.example.healthclock.entity.mongodb.RubbishEntity;
import com.example.healthclock.provider.QiNiuProvider;
import com.example.healthclock.service.RubbishService;
import com.example.healthclock.utils.FileNameUtils;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 14:50
 **/
@Service
public class RubbishServiceImpl implements RubbishService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    QiNiuProvider qiNiuProvider;

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
}
