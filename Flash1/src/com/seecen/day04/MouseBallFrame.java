package com.seecen.day04;

import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;

/**
 * @program: Flash
 * @Author: Jim Chan
 * @Description:
 * @create: 2020-09-10 17:26
 */
public class MouseBallFrame extends JFrame {
    private MouseBallPanel panel;

    public MouseBallFrame(){
        //获取画板对象
        panel = new MouseBallPanel();
        //画板装载
        this.add(panel);
    }
    public void showMe(){
        this.setSize(400,600);
        this.setVisible(true);
        this.setTitle("飞机大战");
        panel.startRun();
    }

    public static void main(String[] args) {
        MouseBallFrame frame = new MouseBallFrame();
        frame.showMe();
    }
}
