package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

public class ReTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(1024,768);
        jf.setTitle("星星");
        JPanelW jp = new JPanelW();

        jf.add(jp);
    }
}

class JPanelW extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.black);
        g.setColor(Color.white);
        for (int i = 0; i < 300; i++) {
            g.setColor(new Color((int)(0xfffff*Math.random())));
            g.setFont(new Font("宋体",Font.BOLD,(int)(15+Math.random()*15)));
            g.drawString("*",(int)(1024*Math.random()),(int)(768*Math.random()));
        }
    }
}
