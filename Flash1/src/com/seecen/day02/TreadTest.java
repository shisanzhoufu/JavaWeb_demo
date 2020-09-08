package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

public class TreadTest {
    public static void main(String[] args) {
        //创建线程对象
        Thread thread = new Thread(){
            @Override
            //当前线程的执行体，表示该线程要做到事情
            public void run() {
//                super.run();
                for (int i = 0; i < 10; i++) {
                    System.out.println("hihihi");
                    //异常捕获，alt+enter，处理程序运行风险
                    try {
                        //类似定时器，睡眠2s
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //使得线程对象进入就绪状态
        thread.start();
    }
}
