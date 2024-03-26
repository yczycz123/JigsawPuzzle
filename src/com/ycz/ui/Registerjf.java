package com.ycz.ui;

import javax.swing.*;

public class Registerjf extends JFrame {

    public Registerjf(){
        this.setSize(488,500);

        this.setTitle("注册");
        //设置界面置顶，即始终显示在桌面的最前面，不会被盖住
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
