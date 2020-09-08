package com.seecen.day02;

import javax.swing.*;
import java.awt.*;

public class ConstructorTest {
    public static void main(String[] args) {
        Elephant ele = new Elephant();
        ele.show();
    }
}

class Elephant{
    String name;
    int age;
    public Elephant() {
        name = "jack";
        age = 90;
    }
    public void show(){
        System.out.println("Hi,I am "+ name +",I am "+age);
    }
}

