package com.ycz.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Myframe3 extends JFrame implements KeyListener {


    JButton jButton1=new JButton("按钮1");

    public Myframe3() {
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("拼图单机版");
        //设置界面置顶，即始终显示在桌面的最前面，不会被盖住
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //3即关闭游戏同时关闭虚拟机，2是关闭所有界面时才关闭虚拟机

        //取消默认的放置模式，以xy轴的放置模式添加组件
        this.setLayout(null);

        jButton1.setBounds(0,0,100,100);
        jButton1.addKeyListener(this); //因为当前类实现了ActionListener接口，故可以用this调用，这是接口的多态


        this.add(jButton1);
        this.setVisible(true);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按键按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("按键松开");
    }
}
