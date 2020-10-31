package com.example.healthclock.utils;

import cn.hutool.core.util.RandomUtil;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: 杨伟栋
 * @Date: 2020/10/15 21:33
 * @Description: 1371690483@qq.com  时间和时间戳转换类
 */
public class TimeTransformationUtils {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /*
     * @Author 杨伟栋
     * @Description 将特定日期转换成时间戳
     * @Date 2020/10/15 9:36 下午
     * @Param date 特定的日期(相当于当日的零点)
     * @return
     **/
    public static long DateToTimestmp(String date) {

        try {
            return df.parse(date).getTime()/1000;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /*
     * @Author 杨伟栋
     * @Description 特定时间点转换时间戳
     * @Date 2020/10/15 9:57 下午
     * @Param date日期 time 时间  (2:30:00)
     * @return
     **/
    public static long SpecTimeToTimestmp(String date,String time) {
        String complete_time = date+" "+time;
        try {
            return df1.parse(complete_time).getTime()/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * @Author 杨伟栋
     * @Description 获取当前时间(不带时分秒)
     * @Date 2020/10/15 9:48 下午
     * @Param
     * @return
     **/
    public static String SysCurrTime() {
        return df.format(new Date());
    }

    /*
     * @Author 杨伟栋
     * @Description 获取当前时间(带时分秒)
     * @Date 2020/10/15 9:48 下午
     * @Param
     * @return
     **/
    public static String SysCurrTimestmp() {
        return df1.format(new Date());
    }

    /*
     * @Author 杨伟栋
     * @Description 获取当前时间戳
     * @Date 2020/10/15 9:48 下午
     * @Param
     * @return
     **/
    public static long getLocalStmp() {
        return DateStmpToTimestmp(SysCurrTimestmp());
    }

    /*
     * @Author 杨伟栋
     * @Description 将特定日期转换成时间戳
     * @Date 2020/10/15 9:36 下午
     * @Param date 特定的日期(相当于当日的零点)
     * @return
     **/
    public static long DateStmpToTimestmp(String date) {

        try {
            return df1.parse(date).getTime()/1000;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }


    /*
     * @Author 杨伟栋
     * @Description 获取当天的后一天的 时间
     * @Date 2020/10/15 10:15 下午
     * @Param
     * @return
     **/
    public static String TomorrowDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH,1);
        Date tomorrow = c.getTime();
        return df.format(tomorrow);

    }

    /*
     * @Author 杨伟栋
     * @Description 根据时间戳转换成日期
     * @Date 2020/10/15 10:15 下午
     * @Param timestmp 时间戳   flag   true 纯日期格式 false 带时分秒的日期格式
     * @return
     **/
    public static String TimestmpToDate(long timestmp,boolean flag) {
        return flag?df.format(new Date(Long.parseLong(String.valueOf(timestmp*1000))))
                    :df1.format(new Date(Long.parseLong(String.valueOf(timestmp*1000))));

    }






}
