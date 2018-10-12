package org.study;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 各种测试
 *
 * @author 大兵
 * @date 2018-07-03 10:58
 **/
public class BaseTest {

    @Test
    public void byteTest() {
        byte a = 127;
        byte b = 127;

//        b = a + b;
        b += a;

        System.out.println(b);
    }

    @Test
    public void sss() {
        System.out.println(assss());
    }

    public static String assss() {
        String jjj = "zzz";

        try {
            return jjj;
        } finally {
            jjj = "333";
        }
    }

    @Test
    public void floatTest() {
        float x, y, z;
        x = 1;
        y = 3;
        z = 4;
        System.out.println(y += ++x / z--);
        System.out.println(x + "," + y + "," + z);
    }


    @Test
    public void warpTest() {
        int i = 1;

        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toHexString(Integer.reverse(i)));
        System.out.println(Integer.toHexString(Integer.reverseBytes(i)));

    }

    public void fileTest() {
        try {
            Files.copy(new File("D:\\java").toPath(), new FileOutputStream(new File("E:\\")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void IntToString() {
        Integer i = 1;
//        System.out.println((String) i);
    }

    public int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

    @Test
    public void testAdd() {
        System.out.println(Add(1, 16));
    }
}
