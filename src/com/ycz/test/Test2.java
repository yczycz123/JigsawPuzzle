package com.ycz.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 {
    public static void main(String[] args) {

        JFrame  jFrame=new JFrame();
        //设置界面的宽高
        jFrame.setSize(603,680);
        //设置界面的标题
        jFrame.setTitle("监听测试");
        //设置界面置顶，即始终显示在桌面的最前面，不会被盖住
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置游戏关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //3即关闭游戏同时关闭虚拟机，2是关闭所有界面时才关闭虚拟机

        //取消默认的放置模式，以xy轴的放置模式添加组件
        jFrame.setLayout(null);
        JButton jButton=new JButton("按钮1");
        jButton.setBounds(0,0,100,100);


       // jButton.addActionListener(new myactionlistener());


        //匿名内部类
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点我");
            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jFrame.add(jButton);
        jFrame.setVisible(true);
    }

}
