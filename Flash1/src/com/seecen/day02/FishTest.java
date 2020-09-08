package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

//画一只鱼，能够在水里游动
public class FishTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setTitle("小鱼游啊游");
        jf.setSize(1024,768);
        MyJPanelF jp = new MyJPanelF();
        jf.add(jp);
        jp.move();
    }
}
class MyJPanelF extends JPanel{
    int[] x;
    int[] y;
    int s;
    public MyJPanelF(){
        x = new int[8];
        y = new int[8];
        s = 0;
        for (int i = 0; i < 8; i++) {
            x[i] = (int)(Math.random()*1024);
            y[i] = (int)(Math.random()*768);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.blue);
        for (int i = 0; i < 8; i++) {
            //泡泡
            g.setColor(Color.WHITE);
            g.drawOval(x[i],y[i]-s,10,10);
            //画鱼嘴巴
            g.setColor(Color.RED);
            g.fillOval(x[i],y[i],5,8);
            //画身体
            g.setColor(Color.ORANGE);
            g.fillOval(x[i]-49,y[i]-14,50,30);
            //画眼睛
            g.setColor(Color.BLACK);
            g.fillOval(x[i]-20,y[i]-10,5,10);
            //画尾巴
            g.setColor(Color.BLACK);
            g.fillOval(x[i]-65,y[i]-7,20,15);
            g.setColor(Color.BLUE);
            g.fillOval(x[i]-75,y[i]-7,20,15);
        }

    }
    public void move(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    s++;
                    for(int i = 0; i<8;i++){
                        x[i]+=5;
                        if(x[i]>1024){
                            x[i]=0;
                        }
                    }
                try {
                    Thread.sleep(30);
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
