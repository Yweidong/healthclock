package com.example.healthclock.aspect;

import com.example.healthclock.config.DruidConfig;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @program: healthclock
 * @description: 日志切面
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-10-17 13:40
 **/
@Aspect
@Component
public class MyLogAspect {
    private static final Logger logger = Logger.getLogger(MyLogAspect.class);

    @Pointcut("@annotation(com.example.healthclock.annotation.MyLogAnno)")
    public void myLog() {}

    @Before("myLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();

            logger.info("name:{"+name+"},value:{"+request.getParameter(name)+"}");
        }
    }

    @AfterReturning(returning = "ret", pointcut = "myLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
