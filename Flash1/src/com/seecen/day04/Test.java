package com.seecen.day04;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Flash
 * @Author: Jim Chan
 * @Description:
 * @create: 2020-09-10 10:40
 */
public class Test {
    public static void main(String[] args) {
        int[] xx = new int[5];
        for (int i = 0; i < 5; i++) {
            //0 1 2 3 4
            xx[i] = i;
        }
        //要在xx数组中添加一个元素
        System.out.println("添加之后的数组：");
        xx = Arrays.copyOf(xx,xx.length+1);
        xx[5] = 99;
        for (int i = 0; i < xx.length; i++) {
            System.out.println(xx[i]);
        }
        System.out.println("--------分割线---------");
        //动态数组
        ArrayList list = new ArrayList();
        //add();添加元素的方法
        list.add(1);//0
        list.add(4);//1
        list.add(5);//2
        for (int i = 0; i < list.size(); i++) {
            //get();获取元素的方法
            System.out.println(list.get(i));
        }
        //remove();删除元素的方法
        list.remove(1);
        System.out.println(list);


    }
}
