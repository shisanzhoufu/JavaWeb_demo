package com.seecen.day04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;

/**
 * @program: Flash
 * @Author: Jim Chan
 * @Description:
 * @create: 2020-09-10 08:20
 */
public class PlaneTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(400,600);
        jf.setTitle("飞机划过天空");
        Sky sky = new Sky();
        sky.move();
        jf.add(sky);
    }
}
class Sky extends JPanel implements MouseMotionListener {
    //(x,y)表示我方战机的坐标
    int x,y;
    //获取5组坐标（xx[i],yy[i]）表示敌方战机的位置
    int[] xx,yy;
    public Sky(){
            //给我方战机确定初始位置
            x = 200;
            y = 500;
            //获得数组对象，并使用for循环对其进行赋值
            xx = new int[5];
            yy = new int[5];
            for (int i = 0; i < 5; i++) {
                //通过减掉敌方战机的宽度 使得不会出现战机显示在屏幕之外的情况
                xx[i] = (int)(Math.random()*400)-40;
                //整数数组元素的默认值为0
                //yy[i] = 0;
            }
            //第一个this表示当前Sky类的对象(组件)
            //第二个表示当前鼠标监听器
            this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //获取图片资源
        URL imgUrl = getClass().getResource("back.jpg");
        //通过ImageIcon类的构造方法讲资源转化成ImageIcon对象
        ImageIcon icon = new ImageIcon(imgUrl);
        //icon.getImage()->Image
        g.drawImage(icon.getImage(),0,0,this);
        //实现我方战机1以及敌方战机5
        URL imgUrl1 = getClass().getResource("hero.gif");
        ImageIcon icon1 = new ImageIcon(imgUrl1);
        g.drawImage(icon1.getImage(),x,y,80,40,this);
        URL imgUrl2 = getClass().getResource("el_0.png");
        ImageIcon icon2 = new ImageIcon(imgUrl2);
        for (int i = 0; i < 5; i++) {
            g.drawImage(icon2.getImage(),xx[i],yy[i],40,40,this);
        }
    }

    public void move(){
        Thread thread = new Thread(){
            //通过线程的执行体来使得敌机发生移动
            @Override
            public void run() {
                //每执行一次while循环，都需要让5架敌机往下移动
                while (true){
                    for (int i = 0; i < 5; i++) {
                        yy[i]++;
                        if (yy[i]>600){
                            yy[i]=0;
                        }
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        };
        thread.start();
    }

    @Override
    //鼠标拖动的时候触发的事件
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    //在鼠标移动的时候触发
    public void mouseMoved(MouseEvent e) {
        //通过MouseEvent类型的对象e 来获取当前鼠标的坐标
        x = e.getX()-40;
        y = e.getY()-20;
        repaint();
    }
}
