package com.github.note.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author :Mr.kk
 * @date: 2018/11/28 13:54
 */
@Configuration
@Aspect
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private static final ThreadLocal<Long> timeTreadLocal = new ThreadLocal<>();
    long endTime;


    // ..表示包及子包 该方法代表controller层的所有方法
    @Pointcut("execution(public * com.github.note.controller..*.*(..))")
    public void controllerMethod() {
    }


    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
         long startTime = System.currentTimeMillis();
         timeTreadLocal.set(startTime);
         ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
         logger.info("请求信息：");
         logger.info("URL = {" + request.getRequestURI() + "},\t");
         logger.info("HTTP_METHOD = {" + request.getMethod() + "},\t");
         logger.info("IP = {" + request.getRemoteAddr() + "},\t");
         logger.info("CLASS_METHOD = {" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "},\t");
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        logger.info("请求参数：");
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
           logger.debug(paraName + ": " + request.getParameter(paraName));
        }
    }

    //捕获系统中的异常
    @AfterThrowing(value = "controllerMethod()", throwing = "e")
    public void afterThrowing(Throwable e) {
        if (e instanceof Exception) {
            logger.error("系统发生异常Exception:", e);
        } else {
            logger.error("通知中发现未知异常", e);
        }
    }

    @AfterReturning("controllerMethod()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
        logger.info("WebLogAspect.doAfterReturning()");
        long startTime = timeTreadLocal.get();
        endTime = System.currentTimeMillis();
        logger.info("请求用时：" + (endTime - startTime));
    }

}
