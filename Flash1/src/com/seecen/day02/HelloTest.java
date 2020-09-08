package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

public class HelloTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello DH!!!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("hello,SC!!!");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
