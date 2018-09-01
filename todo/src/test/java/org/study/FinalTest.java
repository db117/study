package org.study;

/**
 * @author 大兵
 * @date 2018-08-31 14:50
 **/
public class FinalTest {
    static final Integer a = 1;

    //final会被当成常亮来使用
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }
}
