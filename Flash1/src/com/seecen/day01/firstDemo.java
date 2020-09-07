package com.seecen.day01;

import javax.swing.*;
import java.awt.*;

public class firstDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(1024,768);
        //窗口标题
        jf.setTitle("game");
        //将画板装载到窗口
        MyJPanel4 jp = new MyJPanel4();
        jf.add(jp);
    }
}
class MyJPanel4 extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.black);
        //笔刷颜色
        g.setColor(Color.white);
        for(int i = 0;i < 300; i++){
            //设置字体，加粗，大小随机
            g.setFont(new Font("宋体",Font.BOLD,(int)(10+Math.random()*10)));
            //通过随机数生成坐标,通过int强行转换为整数形式
            g.drawString("*",(int)(Math.random()*1024),(int)(Math.random()*500));
        }
        g.fillOval(300,600,150,150);
        g.fillOval(315,520,120,120);
        g.setColor(Color.black);
        g.fillOval(395,560,10,10);
        g.fillOval(345,560,10,10);
        int [] x = {300,365,365};
        int [] y = {590,580,600};
        g.setColor(Color.orange);
        g.fillPolygon(x,y,3);

    }
}
