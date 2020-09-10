package com.seecen.day04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Flash
 * @Author: Jim Chan
 * @Description:
 * @create: 2020-09-10 14:59
 */
public class MouseBallPanel extends JPanel
        implements MouseMotionListener, MouseListener {

    private int x,y;//我方战机的位置坐标
    private List<Ball> allBalls;//存放所有弹出的小球(我方战机发射的子弹)
    private List<Ball> allSnows;//存放所有掉下的小球(敌方战机)

    private boolean isFire;//用来跟踪鼠标按键的点击状态

    private Image hero_img =
            new ImageIcon("hero.gif").getImage();

    public MouseBallPanel(){
        //我方战机的初始位置(200,200)
        x = 200;
        y = 200;

        allBalls = new ArrayList<>();
        allSnows = new ArrayList<>();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //加载背景图
        ImageIcon icon = new ImageIcon("back.jpg");
        g.drawImage(icon.getImage(),0,0,this);
        //加载我方战机元素
        g.drawImage(hero_img,x,y,50,50,this);
        //加载所有的敌方战机
        for (int i=0;i<allSnows.size();i++){
            //每循环一次取出来一个Ball类型的对象
            Ball ball = allSnows.get(i);
            //每取出来一个Ball类型的对象就画一个
            //注意自定义的draw方法需要将画笔传进去
            ball.draw(g);
        }
        //加载我方战机所有的子弹
        //allBalls.size().fori
        for (int i = 0; i < allBalls.size(); i++) {
            Ball ball = allBalls.get(i);
            ball.draw(g);
        }

    }
    public void startRun(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                int count = 0;
                while (true){
                    count++;
                    if (count>=Integer.MAX_VALUE){
                        count = 0;
                    }
                    //1.不断补充落下的小球(不断地添加敌机对象进allSnows
                    if (count%60 == 0){
                        Ball ball = new Ball();
                        int tem_x = (int)(Math.random()*400);
                        int tem_y = -40;
                        int tem_r = 20;
                        ball.setX(tem_x);
                        ball.setY(tem_y);
                        ball.setR(tem_r);
                        ball.setType(1);
                        ball.setOrientation(5);
                        allSnows.add(ball);
                    }
                    //2.让所有掉下的小球移动(让敌机往下动)
                    //删除超出屏幕之外的小球
                    for (int i = 0; i < allSnows.size(); i++) {
                        Ball ball = allSnows.get(i);
                        //调用Ball类型对象的move()
                        ball.move();
                        //当前小球(敌机)超出屏幕之外，则删除
                        if (ball.getY()>=600){
                            allSnows.remove(i);
                        }
                    }
                    //3.判断是否处在开火状态,如果在，则添加一个小球
                    //到allBalls()->添加子弹
                    // && 表示两种都成立 才会执行
                    // || 表示只要有一种情况成立 就会执行
                    if (isFire && count%25==0){
                        Ball ball = new Ball();
                        ball.setX(x);
                        ball.setY(y);
                        ball.setR(20);
                        ball.setOrientation(4);
                        ball.setType(0);
                        allBalls.add(ball);
                    }
                    //4.让List中所有的小球移动起来
                    for (int i = 0; i < allBalls.size(); i++) {
                        Ball ball = allBalls.get(i);
                        ball.move();
                        if (ball.getY()<=0){
                            allBalls.remove(i);
                        }
                    }
                    //5.判断小球是否发生碰撞，如果发生碰撞，则删除
                    //allSnows.size().fori
                    for (int i = 0; i < allSnows.size(); i++) {
                        //allBalls.size().fori
                        for (int j = 0; j < allBalls.size(); j++) {
                            //要在数组不越界的情况下进入
                            if (i<allSnows.size()&&j<allBalls.size()&&
                                    allSnows.get(i).isTouch(allBalls.get(j))){
                                allSnows.remove(i);
                                allBalls.remove(j);
                            }
                        }
                    }
                    //6.重新渲染
                    repaint();
                    //7.睡眠
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
        //鼠标按下去的时候出在开火状态
        isFire = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isFire = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX()-25;
        y = e.getY()-25;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX()-25;
        y = e.getY()-25;
    }
}
