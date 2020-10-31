package com.example.healthclock.common;

import com.example.healthclock.exception.ResultException;

import java.util.HashMap;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-30 15:10
 **/
public class Response {
    public static Result getresponse(HashMap map) {
        if(map.get("code").equals(400)) {
            throw new ResultException(ResultStatus.BAD_REQUEST, (String) map.get("message"));
        }else if(map.get("code").equals(200)) {
            return new Result(ResultStatus.SUCCESS,map.get("message"));
        }else if(map.get("code").equals(4000)){
            throw new ResultException(ResultStatus.SPECIAL_CODE, "");
        }else {
            throw new ResultException(ResultStatus.BAD_REQUEST,"当前打卡人数过多，请稍后再试");
        }

    }
}
