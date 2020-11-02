package com.example.healthclock.provider;

import com.example.healthclock.utils.FileNameUtils;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 16:28
 **/
@Component
public class QiNiuProvider {
    @Value("${oss.qiniu.domain}")
    private String domain;

    @Value("${oss.qiniu.bucketName}")
    private String bucketName;
    @Autowired
    Auth auth;
    @Autowired
    Gson gson;
    @Autowired
    UploadManager uploadManager;

    //简单上传模式凭证
    public String getUpToken() {
        return auth.uploadToken(bucketName);
    }

    public String getUpToken(String fileKey) {
        return auth.uploadToken(bucketName,fileKey);
    }

    /**
     *将本地文件上传
     *
     * @param fileKey    上传到七牛云后保存的文件路径名称
     *
     * @return
     */
    public DefaultPutRet upload(String filepath, String fileKey) throws Exception {

        InputStream urlInputStream = FileNameUtils.getUrlInputStream(filepath);

        Response response = uploadManager.put(urlInputStream,fileKey,getUpToken(fileKey),null,null);
        if(response.isOK()) {
            DefaultPutRet defaultPutRet = gson.fromJson(response.bodyString(), DefaultPutRet.class);

            return defaultPutRet;
        }
        return null;

    }
}
