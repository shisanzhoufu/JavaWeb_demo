package com.seecen.day04;

import javax.swing.*;
import java.awt.*;

/**
 * @program: Flash
 * @Author: Jim Chan
 * @Description:
 * @create: 2020-09-10 10:19
 */
public class Ball {
    //private：私有的 只能在当前类内访问
    private int x,y;//小球的左上顶点坐标
    private int r;//圆形化之后半径
    private int orientation;//元素移动的方向 上升:4 下降:5
    private int speed;//小球的移动速度
    private int type;//小球的类型:子弹=0、敌机=1

    //我方战机发出的子弹，上升。
    public static Image image_fire =
            new ImageIcon("fire.gif").getImage();
    //往下掉落的敌机
    public static Image image_ef =
            new ImageIcon("el_0.png").getImage();

    //生成两个构造方法
    //选constructor
    public Ball() {
    }
    public Ball(int x, int y, int r, int orientation, int speed, int type) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.orientation = orientation;
        this.speed = speed;
        this.type = type;
    }
    //将自身显示在组件上
    public void draw(Graphics g){
        //如果是我方战机的子弹，g.drawImage(image_fire...)
        //如果是敌方战机，g.drawImage(image_ef...)
        //如果用确定数量的值来进行判断，使用switch
        /*switch(day){
            case 1:打印...;break;
            case 2:打印...;break;
            case 3:打印...;break;
            case 4:打印...;break;
            case 5:打印...;break;
            case 6:打印...;break;
            case 7:打印...;break;
            default:打印...;break;
        }*/
        switch (type){
            case 0:
                g.drawImage(image_fire,x,y
                        , 2*r,2*r,null);
                break;
            case 1:
                g.drawImage(image_ef,x,y
                        ,2*r,2*r,null);
            break;
        }

    }
    public boolean isTouch(Ball ball){
        //获取当前小球的圆心x坐标
        int x1 = x+r;
        //获取当前小球的圆心y坐标
        int y1 = y+r;
        //获取传进来(与当前对象相比较)的小球圆心x坐标
        int x2 = ball.getX()+ball.getR();
        int y2 = ball.getY()+ball.getR();
        double res = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        //在java当中，用<、>、>=、<=、== 来判断的话，返回结果
        //是boolean类型：true false
        //如果碰撞 返回 true ，没有碰撞则返回false
        return res<=r+ball.getR();
    }
    //用来移动当前Ball类型对象的方法
    //灰色字体:1.注释 2.没有调用过的内容 3.默认的内容
    public void move(){
        switch (orientation){
            //如果ori属性值4，则为往上那个运动的元素
            case 4:
                y--;
                break;
            //如果ori属性值为5，为往下运动的元素
            case 5:
                y++;
                break;
        }
    }
    //alt+Insert来选择要生成的方法
    //选setter and getter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
