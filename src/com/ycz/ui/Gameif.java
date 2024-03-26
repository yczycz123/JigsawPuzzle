package com.ycz.ui;

import javax.swing.*;

public class Gameif extends JFrame {
    public Gameif(){

        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("拼图单机版");
        //设置界面置顶，即始终显示在桌面的最前面，不会被盖住
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面可见，一般放最后
        this.setVisible(true);
    }
}
