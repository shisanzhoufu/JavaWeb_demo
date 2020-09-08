package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

public class MoonTest {
    //java的入口函数，main
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        //设置窗口可视
        jf.setVisible(true);
        //设置窗口大小
        jf.setSize(1024,768);
        //设置窗口标题
        jf.setTitle("月食");
        //创建画板实例，装载到窗口上
        MyJPanel2 jp = new MyJPanel2();
        jf.add(jp);

        jp.move();

    }
}

/*
 * 创建画板类
 * */
class MyJPanel2 extends JPanel{
    int x,y;//黑色月亮的坐标
    public MyJPanel2(){
        x = 640;
        y = 90;
    }
    @Override
    public void paint(Graphics g) {
        //笔刷初始化
        super.paint(g);
        //画板背景颜色
        this.setBackground(Color.black);

        //白月亮
        g.setColor(Color.white);
        g.fillOval(650,100,80,80);
        //黑月亮，修改坐标，移动月亮
        g.setColor(Color.black);
        g.fillOval(x,y,80,80);


    }


    public void move(){
        //黑色遮盖形成月牙
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    x--;
                    y--;
                    if(y<10){
                        x = 640;
                        y = 90;
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //重新渲染元素
                    repaint();
                }
            }
        };
        thread.start();
    }
}

