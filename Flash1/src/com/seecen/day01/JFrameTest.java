package com.seecen.day01;

import javax.swing.*;
import java.awt.*;

/*
* 窗口
*/
public class JFrameTest {
    //java程序的入口，从main方法开始运行程序
    public static void main(String[] args) {
        //获取对象JFrame 通过其实现窗口
        JFrame jf = new JFrame();
        //调用visible，使得窗口显示在操作系统中
        jf.setVisible(true);
        //窗口初始化大小
        jf.setSize(1024,768);
        //窗口标题
        jf.setTitle("game");
        //将画板装载到窗口
        MyJPanel jp = new MyJPanel();
        jf.add(jp);

    }
}

/*
* 画板类 JPanel
* 继承 extends
*/
class MyJPanel extends JPanel{

    @Override
    public void paint(Graphics g) {
        //画笔初始化
        super.paint(g);
        //设置背景颜色
        this.setBackground(Color.black);
        //设置画笔颜色
        g.setColor(Color.white);
        //设置图标及xy轴坐标
        g.drawString("·",300,300);
    }
}