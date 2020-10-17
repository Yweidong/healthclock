package com.example.healthclock.annotation;

import java.lang.annotation.*;

/**
 * @program: healthclock
 * @description: 日志自定义注解
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-17 13:53
 **/
@Target(ElementType.METHOD)//注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface MyLogAnno {
}
