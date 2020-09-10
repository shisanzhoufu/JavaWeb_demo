package com.seecen.day03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

public class PictureTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setTitle("小鱼游啊游");
        jf.setSize(1024,768);
        MyJPanel1 jp = new MyJPanel1();
        jf.add(jp);
        jp.move();
    }
}
class MyJPanel1 extends JPanel implements MouseListener ,MouseMotionListener{
    int x1 = 0 ,y1 = 0;
    int x2 = 100 ,y2 = 100;
    int x3 = 400 ,y3 = 200;
    int x4 = 600 ,y4 = 400;
    int x5 = 500 ,y5 = 500;
    int[] yy1, yy2, yy3, yy4;
    public MyJPanel1(){
        yy1 = new int[15];
        yy2 = new int[15];
        yy3 = new int[15];
        yy4 = new int[15];
        for (int i = 0; i < 15; i++) {
            yy1[i] = (int)(Math.random()*1000);
            yy2[i] = (int)(Math.random()*1000);
            yy3[i] = (int)(Math.random()*1000);
            yy4[i] = (int)(Math.random()*1000);
        }
        this.addMouseListener((MouseListener) this);
        this.addMouseMotionListener((MouseMotionListener) this);

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //获取图片资源
        URL imgUrl = getClass().getResource("2.jpg");

        //将图片转化为ImageIcon类型
        ImageIcon icon = new ImageIcon(imgUrl);
        //通过icon对象的getImage()方法返回片类型，并使用g.drawImage加载图片到画板
        g.drawImage(icon.getImage(),x1,y1,this);

        URL imgUrl1 = getClass().getResource("1.png");
        ImageIcon icon1 = new ImageIcon(imgUrl1);
        g.drawImage(icon1.getImage(),x2,y2,this);

        URL imgUrl3 = getClass().getResource("3.png");
        ImageIcon icon3 = new ImageIcon(imgUrl3);
        g.drawImage(icon3.getImage(),x3,y3,this);

        URL imgUrl4 = getClass().getResource("4.png");
        ImageIcon icon4 = new ImageIcon(imgUrl4);
        g.drawImage(icon4.getImage(),x4,y4,this);

        URL imgUrl5 = getClass().getResource("5.png");
        ImageIcon icon5 = new ImageIcon(imgUrl5);
        g.drawImage(icon5.getImage(),x5,y5,this);
        //Paopao
        g.setColor(Color.white);
        for (int i = 0; i < 15; i++) {
            g.drawOval(100,yy1[i],20,20);
            g.drawOval(400,yy2[i],20,20);
            g.drawOval(800,yy3[i],20,20);
            g.drawOval(1100,yy4[i],20,20);
        }

    }
    public void move(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    x2--;
                    x3-=3;
                    x4-=2;
                    x5++;
                    if(x2<166){
                        x2 = 1600;
                    }
                    if(x3<-223){
                        x3 = 1600;
                    }
                    if(x4<-353){
                        x4 = 1600;
                    }
                    if(x5>1600){
                        x5 = -204;
                    }
                    for (int i = 0; i < 15; i++) {
                        yy1[i]--;
                        if(yy1[i]<0){
                            yy1[i] = 1000;
                        }
                        yy2[i]--;
                        if(yy2[i]<0){
                            yy2[i] = 1000;
                        }
                        yy3[i]--;
                        if(yy3[i]<0){
                            yy3[i] = 1000;
                        }
                        yy4[i]--;
                        if(yy4[i]<0){
                            yy4[i] = 1000;
                        }
                    }
                try {
                    Thread.sleep(50);
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
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x5 = e.getX()-102;
        y5 = e.getY()-89;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
