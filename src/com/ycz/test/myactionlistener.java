package com.ycz.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class myactionlistener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被出发了");
    }
}
