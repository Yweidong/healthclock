package com.example.healthclock.config;

import com.google.gson.Gson;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: healthclock
 * @description: 七牛云配置
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 15:41
 **/
@Configuration
public class QiniuyunConfig {

    @Value("${oss.qiniu.domain}")
    private String domain;

    @Value("${oss.qiniu.accessKey}")
    private String accessKey;

    @Value("${oss.qiniu.secretKey}")
    private String secretKey;

    @Value("${oss.qiniu.bucketName}")
    private String bucketName;

    @Bean
    public com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(Region.region0());
    }

    /**
     *
     *构建一个七牛上传工具实例
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    /**
     *
     *认证信息实例
     */
    @Bean
    public Auth auth() {
        return Auth.create(accessKey,secretKey);
    }

    /**
     *
     *构建七牛空间管理实例
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(),qiniuConfig());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
