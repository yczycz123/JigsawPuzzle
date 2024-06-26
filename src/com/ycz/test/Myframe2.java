package com.ycz.test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Myframe2 extends JFrame implements MouseListener {

    JButton jButton1=new JButton("按钮1");

    public Myframe2() {
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
        jButton1.addMouseListener(this); //因为当前类实现了ActionListener接口，故可以用this调用，这是接口的多态


        this.add(jButton1);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
