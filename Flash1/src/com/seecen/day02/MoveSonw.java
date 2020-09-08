package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

public class MoveSonw {
        public static void main(String[] args) {
            JFrame jf = new JFrame();
            jf.setVisible(true);
            jf.setSize(1024,768);
            //窗口标题
            jf.setTitle("game");
            //将画板装载到窗口
            MyJPanelM jp = new MyJPanelM();
            jf.add(jp);
            jp.move();
        }
    }
    class MyJPanelM extends JPanel{

        int[] x;
        int[] y;
        public MyJPanelM(){
            x = new int[300];
            y = new int[300];
            for (int i = 0; i < 300; i++) {
                x[i] = (int)(Math.random()*1024);
                y[i] = (int)(Math.random()*768);
            }
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            this.setBackground(Color.black);
            //笔刷颜色
            g.setColor(Color.white);
            for (int i = 0; i < 300; i++) {
                //设置字体，加粗，大小随机
                g.setFont(new Font("宋体",Font.BOLD,25));
                //通过随机数生成坐标,通过int强行转换为整数形式
                g.drawString("*",x[i],y[i]);
            }


            //雪人
            g.fillOval(300,600,150,150);
            g.fillOval(315,520,120,120);
            g.setColor(Color.black);
            //眼睛
            g.fillOval(395,560,10,10);
            g.fillOval(345,560,10,10);
            //鼻子
            int [] x = {300,365,365};
            int [] y = {590,580,600};
            g.setColor(Color.orange);
            g.fillPolygon(x,y,3);

        }
        public void move(){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    while(true){
                        for(int i = 0; i<300;i++){
                            y[i]+=5;
                            if(y[i]>768){
                                y[i]=0;
                            }
                        }

                        try {
                            Thread.sleep(50);
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
