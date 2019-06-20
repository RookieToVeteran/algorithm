package com.algorithm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * @program: algorithm
 * @description: 日志切面
 * @author: pengpeng.wang.o
 * @create: 2019-06-19
 **/
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * @Description:  配置切入点
     * @Author: pengpeng.wang.o
     * @Date: 2019/6/19
     * @Param: []
     * @return: void
     */
    @Pointcut("execution(* com.algorithm.project.controller..*.*(..))")
    public void pointCut(){}

    /**
     * @Description: 前置通知，方法开始前打印日志
     * @Author: pengpeng.wang.o
     * @Date: 2019/6/19
     * @Param: [joinPoint]
     * @return: void
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        StringBuffer annotationValue = new StringBuffer();
        try {
            MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            Method method = signature.getMethod();
            Class<?> clazz = joinPoint.getTarget().getClass();
            method = clazz.getMethod(method.getName(), method.getParameterTypes());
            if (clazz.isAnnotationPresent(RequestMapping.class)){
                RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
                String[] values = annotation.value();
                for (String value : values) {
                    annotationValue.append(value);
                }
            }
            if (method != null && method.isAnnotationPresent(GetMapping.class)){
                GetMapping annotation = method.getAnnotation(GetMapping.class);
                String[] values = annotation.value();
                for (String value : values) {
                    annotationValue.append(value);
                }
            }else if (method != null && method.isAnnotationPresent(PostMapping.class)){
                PostMapping annotation = method.getAnnotation(PostMapping.class);
                String[] values = annotation.value();
                for (String value : values) {
                    annotationValue.append(value);
                }
            }else if (method != null && method.isAnnotationPresent(RequestMapping.class)){
                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                String[] values = annotation.value();
                for (String value : values) {
                    annotationValue.append(value);
                }
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                String s = parameterType.toString();
            }
            logger.error("======"+annotationValue.toString()+",入参data="+method.getParameterTypes());
        } catch (NoSuchMethodException e) {
            logger.error(annotationValue+">>>>>>方法不存在>>>>>>");
        }
    }

    /**
     * @Description: 后置通知，方法执行结束后打印日志
     * @Author: pengpeng.wang.o
     * @Date: 2019/6/19
     * @Param: []
     * @return: void
     */
    @After("pointCut()")
    public void after(JoinPoint joinPoint){

    }

}
