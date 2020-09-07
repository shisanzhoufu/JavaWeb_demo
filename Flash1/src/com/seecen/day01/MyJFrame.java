package com.seecen.day01;

import javax.swing.*;
import java.awt.*;

public class MyJFrame {
    //java的入口函数，main
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        //设置窗口可视
        jf.setVisible(true);
        //设置窗口大小
        jf.setSize(1024,768);
        //设置窗口标题
        jf.setTitle("star");
        //创建画板实例，装载到窗口上
        MyJPanel2 jp = new MyJPanel2();
        jf.add(jp);
    }
}

/*
* 创建画板类
* */
class MyJPanel2 extends JPanel{
    @Override
    public void paint(Graphics g) {
        //笔刷初始化
        super.paint(g);
        //画板背景颜色
        this.setBackground(Color.black);
        //笔刷颜色
        g.setColor(Color.white);

        //笔刷样式及坐标
        for(int i = 0;i < 300; i++){
            //通过十六进制生成随机颜色
            g.setColor(new Color((int)(0xffffff*Math.random())));
            //设置字体，加粗，大小随机
            g.setFont(new Font("宋体",Font.BOLD,(int)(10+Math.random()*10)));
            //通过随机数生成坐标,通过int强行转换为整数形式
            g.drawString("*",(int)(Math.random()*1024),(int)(Math.random()*768));
        }

        //月亮
        g.setColor(Color.white);
        g.fillOval(650,100,80,80);
        //黑色遮盖形成月牙
        g.setColor(Color.black);
        g.fillOval(620,100,80,80);

    }
}
