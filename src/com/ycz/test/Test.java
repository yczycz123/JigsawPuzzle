package com.ycz.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {

        //打乱数组中的元素的方法:遍历数组，得到数组中的每一个元素，拿着数组中每一个元素与随机索引进行交换
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random rm = new Random();

        for (int i = 0; i < arr.length; i++) {

            //获取到随即索引a
            int a = rm.nextInt(16);
            int temp = arr[a];
            arr[a] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        //以4个为一组的方式加载到二维数组中
        //写法1：
        int[][] data = new int[4][4];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                data[i][j] = arr[4 * i + j];
//            }
//        }
        System.out.println("\n"+data.length);
        //写法2：
        for (int i = 0; i < arr.length; i++) {
            data[i / 4][i % 4] = arr[i];
        }

        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(data[i][j] + " ");
            }
        }
    }
}
