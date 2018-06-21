package org.study;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * 测试反射
     */
    @Test
    public void reflect() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Norm norm = new Norm();
        Class c = norm.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            // 获取属性的名字
            String name = field.getName();
            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            // 获取属性的类型
            String type = field.getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            System.out.println("属性为：" + name);

            Method set = c.getMethod("set" + name, String.class);

            set.invoke(norm, "999");

            Method get = c.getMethod("get" + name);
            // 调用getter方法获取属性值
            String value = (String) get.invoke(norm);
            System.out.println(value);

            System.out.println(norm.toString());
        }
    }

    @Test
    public void tttt() throws IOException {
        // 类加载根路径
        String classPath = this.getClass().getResource("/").getPath();

        // 类加载根路径
        URL xmlPath = this.getClass().getClassLoader().getResource("");

        // 类所在工程根路径
        String proClassPath = this.getClass().getResource("").getPath();

        // 项目服务器脚本文件路径
        File directory = new File("");// 参数为空
        String proRootPath = directory.getCanonicalPath();

        // 项目服务器脚本文件路径
        String proPath = System.getProperty("user.dir");

        // 获取所有的类路径 包括jar包的路径
        String allClassPath = System.getProperty("java.class.path");

        // 项目部署的路径
        //        String path = request.getSession().getServletContext().getRealPath("/");

        System.out.println("类加载根路径:" + classPath);
        System.out.println("类加载根路径:" + xmlPath);
        System.out.println("类所在工程路径:" + proClassPath);
        System.out.println("项目服务器脚本文件路径:" + proRootPath);
        System.out.println("项目服务器脚本文件路径:" + proPath);
        System.out.println("项目部署的路径:" + allClassPath);
        //        System.out.println("获取所有的类路径:" + path );
    }
}
