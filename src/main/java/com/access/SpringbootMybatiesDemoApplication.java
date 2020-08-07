package com.access;

import com.access.controller.UserController;
import com.access.services.IPermissionService;
import com.access.services.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

@SpringBootApplication
@MapperScan("com.access.dao")
public class SpringbootMybatiesDemoApplication {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService iPermissionService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringbootMybatiesDemoApplication.class, args);

        // 创建一个配置文件的对象
        Properties properties = new Properties();

        // 创建类加载器 获取配置文件 并通过字节流将写入创建的配置文件对象中
        ClassLoader classLoader = UserController.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        properties.load(inputStream);

        // 从配置文件的对象中获取类名 以及方法名称
        String classname = properties.getProperty("className");
        String methodname = properties.getProperty("methodName");
        System.out.print("classname:"+ classname+"---------------------methodname:" + methodname);
        // 通过类名 反射加载类的字节码对象进入内存中
        Class cls = Class.forName(classname);

        Field[] fileds = cls.getDeclaredFields();
        for(Object object:fileds){
            System.out.print(object);
        }
        // 通过字节码对象创建java对象
        Object obj  = cls.newInstance();
        // 找到方法
        Method method = cls.getMethod(methodname);
        // 执行
        method.invoke(obj);
    }

}
