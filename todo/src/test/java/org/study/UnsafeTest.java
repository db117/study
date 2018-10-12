package org.study;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 非安全类测试
 *
 * @author 大兵
 * @date 2018-09-10 9:49
 **/
public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        System.out.println(unsafe.getAddress(1));
    }
}
