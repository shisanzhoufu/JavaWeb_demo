package com.seecen.day01;

import javax.swing.*;
import java.awt.*;

public class DrawTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(1024,768);
        //窗口标题
        jf.setTitle("game");
        //将画板装载到窗口
        MyJPanel3 jp = new MyJPanel3();
        jf.add(jp);
    }
}
class MyJPanel3 extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.black);
        //设置画笔颜色
        g.setColor(Color.white);
        g.drawRect(200,300,80,80);
        g.fillRect(205,305,70,70);
        //画三角形
        int [] x = {70,155,90};
        int [] y = {92,101,26};
        g.drawPolygon(x,y,3);
    }
}
