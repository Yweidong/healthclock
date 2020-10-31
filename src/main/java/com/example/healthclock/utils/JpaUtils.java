package com.example.healthclock.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.stream.Stream;

/**
 * @program: healthclock
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-28 16:48
 **/
public class JpaUtils {
    public static void copyNotNullProperties(Object src,Object target){
        BeanUtils.copyProperties(src,target,getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames(Object object) {
        final BeanWrapperImpl wrapper = new BeanWrapperImpl(object);

        return Stream.of(wrapper.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)//获取bean对象各个属性的名字
                .filter(propertyName -> wrapper.getPropertyValue(propertyName) == null)//过滤字段为null的
                .toArray(String[]::new);
    }
}
