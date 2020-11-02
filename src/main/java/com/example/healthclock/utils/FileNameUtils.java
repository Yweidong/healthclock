package com.example.healthclock.utils;

import cn.hutool.core.date.DateUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.UUID;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-31 16:45
 **/
public class FileNameUtils {


    public static String getRandomImgName(String fileName) {

        int index = fileName.lastIndexOf(".");

        if ((fileName == null || fileName.isEmpty()) || index == -1){
            throw new IllegalArgumentException();
        }
        // 获取文件后缀
        String suffix = fileName.substring(index);
        // 生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 生成上传至云服务器的路径
        String path = "file/laji/"+ uuid + suffix;
        return path;
    }
    /**
     *图片地址转换成 流数据/字节流
     * @param filepath  图片地址
     *
     */
    public static InputStream getUrlInputStream(String filepath) throws Exception {
        URL httpUrl = new URL(filepath);
        HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        InputStream inputStream = conn.getInputStream();

        return inputStream;


    }

}
