package org.study.locks;/*
 * ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 * 图灵学院-悟空老师
 * www.jiagouedu.com
 * 悟空老师QQ：245553999
 *
 * 还没开始
 */

public class Sync02 implements Runnable {
    static volatile int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            add();

        }
    }

    public static void add() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        Sync02 sync02 = new Sync02();
        Thread thread1 = new Thread(sync02);
        Thread thread2 = new Thread(sync02);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);


    }


}
