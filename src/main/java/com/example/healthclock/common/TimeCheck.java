package com.example.healthclock.common;

import com.example.healthclock.utils.TimeTransformationUtils;

/**
 * @program: healthclock
 * @description: 判断学段打卡的时间点
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-27 16:22
 **/
public class TimeCheck {

    public static Integer getQuantum(String date,Integer stage) {

        String dates = TimeTransformationUtils.TimestmpToDate(TimeTransformationUtils.DateToTimestmp(date),true);

        String tomorrowDate = TimeTransformationUtils.TomorrowDate();

        if(stage.equals(0)) {
            if(TimeTransformationUtils.DateStmpToTimestmp(date)>TimeTransformationUtils.SpecTimeToTimestmp(dates,"00:00:00") &&
                    TimeTransformationUtils.DateStmpToTimestmp(date)<=TimeTransformationUtils.SpecTimeToTimestmp(dates,"10:00:00")
            ) {
                return 1;
            }else if(TimeTransformationUtils.DateStmpToTimestmp(date)>TimeTransformationUtils.SpecTimeToTimestmp(dates,"10:00:00") &&
                    TimeTransformationUtils.DateStmpToTimestmp(date)<=TimeTransformationUtils.SpecTimeToTimestmp(dates,"14:02:00")) {
                return 2;
            }else if(TimeTransformationUtils.DateStmpToTimestmp(date)>TimeTransformationUtils.SpecTimeToTimestmp(dates,"14:02:00") &&
                    TimeTransformationUtils.DateStmpToTimestmp(date)<=TimeTransformationUtils.SpecTimeToTimestmp(tomorrowDate,"00:00:00")) {
                return 3;
            }
        }else {
            if(TimeTransformationUtils.DateStmpToTimestmp(date)>TimeTransformationUtils.SpecTimeToTimestmp(dates,"00:00:00") &&
                    TimeTransformationUtils.DateStmpToTimestmp(date)<=TimeTransformationUtils.SpecTimeToTimestmp(dates,"09:00:00")
            ) {
                return 1;
            }else if(TimeTransformationUtils.DateStmpToTimestmp(date)>TimeTransformationUtils.SpecTimeToTimestmp(dates,"09:00:00") &&
                    TimeTransformationUtils.DateStmpToTimestmp(date)<=TimeTransformationUtils.SpecTimeToTimestmp(dates,"14:02:00")) {
                return 2;
            }else if(TimeTransformationUtils.DateStmpToTimestmp(date)>TimeTransformationUtils.SpecTimeToTimestmp(dates,"14:02:00") &&
                    TimeTransformationUtils.DateStmpToTimestmp(date)<=TimeTransformationUtils.SpecTimeToTimestmp(tomorrowDate,"00:00:00")) {
                return 3;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(TimeCheck.getQuantum("2020-10-27 09:36:22",0));
    }


}
