package com.ycz.ui;

import javax.swing.*;

public class Gameif extends JFrame {
    public Gameif(){

        //初始化界面
        init();

        //初始化菜单
        initjmenu();

        //初始化图片
        initimage();
        //设置界面可见，一般放最后
        this.setVisible(true);
    }

    private void initimage() {
        int number=1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个图片的对象
                ImageIcon icon=new ImageIcon("D:\\study\\language\\java\\code\\JigsawPuzzle\\image\\animal\\animal3\\"+number+".jpg");
                number++; //当number自增到16时，由于找不到路径，就会添加一个空白
                //创建一个管理容器的对象
                JLabel jLabel=new JLabel(icon);
                //指定图片放置位置
                jLabel.setBounds(105*j,105*i,105,105);
                //将图片添加进jframe中
                this.getContentPane().add(jLabel);
            }
        }

    }

    public void initjmenu() {
        //创建菜单对象
        JMenuBar jMenuBar=new JMenuBar();

        //创建菜单上的选项
        JMenu functionmenu=new JMenu("功能");
        JMenu aboutmenu=new JMenu("关于我们");


        //创建选项下面的条目
        JMenuItem changeimage=new JMenuItem("更换图片");
        JMenuItem replay=new JMenuItem("重新游戏");
        JMenuItem relogin=new JMenuItem("重新登录");
        JMenuItem closegame=new JMenuItem("关闭游戏");


        JMenuItem Publicaccount=new JMenuItem("公众号");

        //将条目添加到选项中
        functionmenu.add(changeimage);
        functionmenu.add(replay);
        functionmenu.add(relogin);
        functionmenu.add(closegame);

        aboutmenu.add(Publicaccount);

        //将选项添加到菜单中
        jMenuBar.add(functionmenu);
        jMenuBar.add(aboutmenu);


        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    public void init() {
        //设置界面的宽高
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
    }
}
