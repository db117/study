package org.study;

import org.junit.Test;

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
}
