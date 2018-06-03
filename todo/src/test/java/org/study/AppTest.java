package org.study;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.NonReadableChannelException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
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
}
