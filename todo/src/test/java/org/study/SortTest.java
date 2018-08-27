package org.study;

import org.junit.Test;

import java.util.Random;

/**
 * 排序测试
 *
 * @author 大兵
 * @date 2018-08-20 21:14
 **/
public class SortTest {
    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] ints) {
        //标记是否已经是有序
        boolean flag = true;
        //如果已经有序则退出循环
        for (int i = 1; i < ints.length - 1 && flag; i++) {
            flag = false;
            for (int j = ints.length - 1; j >= i; j--) {
                if (ints[j] < ints[j - 1]) {
                    //交换元素
                    int temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                    //如果发生交换则继续循环
                    flag = true;
                }
            }
        }
    }

    /**
     * 简单选择排序
     * 相对于冒泡排序减少了交换次数
     */
    public void selectSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            //默认当前下标位最小值
            int min = i;

            for (int j = i + 1; j < ints.length; j++) {
                //找出最小值的下标
                if (ints[min] > ints[j]) {
                    min = j;
                }
                //如果最小值默认最小值则交换
                if (min != i) {
                    int temp = ints[min];
                    ints[min] = ints[i];
                    ints[i] = temp;
                }
            }

        }
    }

    /**
     * 直接插入排序
     */
    public void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            //当前值
            int temp = ints[i];

            //记录需要插入的位置
            int position = i;

            //对已经排好序的部分进行比较
            for (int j = i - 1; j >= 0; j--) {
                //如果比当前值大,说明被比较的值需要向后移动一位,并且记住当前的下标
                if (temp < ints[j]) {
                    ints[j + 1] = ints[j];
                    position--;
                } else {
                    //如果比当前值小说明当前值要比以排序的所有值大
                    break;
                }
            }
            //把当前值插入到记录的位置中
            ints[position] = temp;
        }
    }


    @Test
    public void sort() {
        Random random = new Random();
        int[] ints = new int[100000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();
//        bubbleSort(ints);

//        selectSort(ints);

//        insertSort(ints);

        QuickSort.sort(ints, 0, ints.length - 1);

//        System.out.println(Arrays.toString(ints));

        System.out.println(System.currentTimeMillis() - start);
    }
}
