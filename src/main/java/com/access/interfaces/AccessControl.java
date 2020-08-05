package com.access.interfaces;

import java.lang.annotation.*;

/**
 * @Desc 通过元注解自定义权限注解，用于AOP进行权限拦截控制
 * @Author kole
 * @Date 2020-08-02
 */
@Target(ElementType.METHOD)// 用于表示该注解用于什么地方
@Retention(RetentionPolicy.RUNTIME)// 用于表示该注解的生命周期，即什么时候生效
@Documented// 注解信息添加到文本中
public @interface AccessControl {

    String accessCode() default "";

    String accessName() default "";
}
