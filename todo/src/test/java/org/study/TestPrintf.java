package org.study;

import org.junit.Test;

import static java.lang.System.out;

/**
 * 字符串格式化输出
 *
 * @author 大兵
 * @date 2018-07-05 22:45
 **/
public class TestPrintf {

    @Test
    public void printf() {
        //定义一些变量，用来格式化输出。
        double d = 345.678;
        String s = "你好！";
        int i = 1234;

        //"%"表示进行格式化输出，"%"之后的内容为格式的定义。

        //"f"表示格式化输出浮点数。
        out.printf("%f", d).println();

        //"9.2"中的9表示输出的长度，2表示小数点后的位数。
        out.printf("%9.2f", d).println();

        //"+"表示输出的数带正负号。
        out.printf("%+9.2f", d).println();

        //"-"表示输出的数左对齐（默认为右对齐）。
        out.printf("%-9.4f", d).println();

        //"+-"表示输出的数带正负号且左对齐。
        out.printf("%+-9.3f", d).println();

        //"d"表示输出十进制整数。
        out.printf("%d", i).println();

        //"o"表示输出八进制整数。
        out.printf("%o", i).println();

        //"x"表示输出十六进制整数。
        out.printf("%x", i).println();

        //"#x"表示输出带有十六进制标志的整数。
        out.printf("%#x", i).println();

        //"s"表示输出字符串。
        out.printf("%s", s).println();
        out.printf("输出一个浮点数：%f，一个整数：%d，一个字符串：%s", d, i, s).println();

        //可以输出多个变量，注意顺序。
        out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x", i, s);
        //"X$"表示第几个变量。
    }
}
