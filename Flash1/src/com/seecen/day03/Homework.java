package com.seecen.day03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

public class Homework {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setTitle("飞机");
        jf.setSize(1024,768);
        JPanelH jp = new JPanelH();
        jf.add(jp);
        jp.move();
    }
}
class JPanelH extends JPanel implements MouseListener, MouseMotionListener {
    int x1 = 0 ,y1 = 0;
    int x2 = 100 ,y2 = 100;
    int x3 = 500 ,y3 = 380;
    int[] x;
    int[] y;
    public JPanelH(){
        x = new int[8];
        y = new int[8];
        for (int i = 0; i < 8; i++) {
            x[i] = (int)(Math.random()*900);
            y[i] = (int)(Math.random()*300);
        }
        this.addMouseListener((MouseListener) this);
        this.addMouseMotionListener((MouseMotionListener) this);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        URL imgUrl = getClass().getResource("back.jpg");
        ImageIcon icon = new ImageIcon(imgUrl);
        g.drawImage(icon.getImage(),x1,y1,1024,768,this);

        URL imgUrl1 = getClass().getResource("hero.gif");
        ImageIcon icon1 = new ImageIcon(imgUrl1);
        g.drawImage(icon1.getImage(),x2,y2,100,80,this);

        for (int i = 0; i < 5; i++) {
            URL imgUrl3 = getClass().getResource("el_0.png");
            ImageIcon icon3 = new ImageIcon(imgUrl3);
            g.drawImage(icon3.getImage(),x[i],y[i],50,60,this);
        }
    }

    public void move(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    for(int i = 0; i<8;i++){
                        y[i]+=5;
                        if(y[i]>1024){
                            y[i]=0;
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
        x2 = e.getX()-50;
        y2 = e.getY()-40;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
