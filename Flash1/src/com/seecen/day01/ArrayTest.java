package com.seecen.day01;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int [] arr1 = new int[6];
        for(int i = 0;i <= 5;i++){
            arr1[i] = 100*i;
        }
        System.out.println(Arrays.toString(arr1));
        //第二种方法
        int[] arr2 = {600,700,800};
        System.out.println(Arrays.toString(arr2));
        for(int i = 0;i < 3;i++){
            System.out.println(arr2[i]);
        }
        //第三种方法
        int[] arr3 = new int[]{900,1000,1100};
        System.out.println(arr3[2]);
    }
}
