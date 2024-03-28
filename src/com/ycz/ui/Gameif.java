package com.ycz.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameif extends JFrame implements KeyListener, ActionListener {

    //打乱数组中的元素的方法:遍历数组，得到数组中的每一个元素，拿着数组中每一个元素与随机索引进行交换
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    Random rm = new Random();
    int[][] data = new int[4][4];

    //步数
    int temp=0;


    JMenuItem replay = new JMenuItem("重新游戏");
    JMenuItem relogin = new JMenuItem("重新登录");
    JMenuItem closegame = new JMenuItem("关闭游戏");
    JMenuItem Publicaccount = new JMenuItem("公众号");
    int[][] win_data={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    String path = "..\\JigsawPuzzle\\image\\animal\\animal3\\";

    public Gameif() {

        //初始化界面
        init();
        //初始化菜单
        initjmenu();
        //打乱数据
        initdata();
        //初始化图片
        initimage();
        //设置界面可见，一般放最后
        this.setVisible(true);
    }


    int blank_x = 0;  //记录空白图片的x坐标
    int blank_y = 0;  //记录空白图片的y坐标

    private void initdata() {
        for (int i = 0; i < arr.length; i++) {

            //获取到随机索引a
            int a = rm.nextInt(16);
            int temp = arr[a];
            arr[a] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                blank_x = i / 4;
                blank_y = i % 4;
            }
            data[i / 4][i % 4] = arr[i];
        }


        //   System.out.println(blank_x+" "+blank_y);
    }

    private void initimage() {
        //清空所有图片
        this.getContentPane().removeAll();

        //由于先加载的图片在最前面，所以添加胜利图片时最先添加
        if(judge_win()){
            JLabel win_jf=new JLabel(new ImageIcon("D:\\study\\language\\java\\code\\JigsawPuzzle\\image\\win.png"));
            win_jf.setBounds(203,203,197,73);
            this.getContentPane().add(win_jf);
        }

        JLabel jtemp=new JLabel("步数"+temp);
        jtemp.setBounds(50,30,100,20);
        this.getContentPane().add(jtemp);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个图片的对象，这里路径可以用相对路径，也可以用绝对路径
                ImageIcon icon = new ImageIcon(path + data[i][j] + ".jpg");
                //创建一个管理容器的对象
                JLabel jLabel = new JLabel(icon);
                //指定图片放置位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //添加小图片的边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //将图片添加进jframe中
                this.getContentPane().add(jLabel);
            }
        }
        //由于先加载的图片在最前面，所以添加背景图片时最后添加
        JLabel jLabel_back = new JLabel(new ImageIcon("..\\JigsawPuzzle\\image\\background.png"));
        jLabel_back.setBounds(40, 40, 508, 560);//设置大小和放置位置
        this.getContentPane().add(jLabel_back);



        //刷新页面
        this.getContentPane().repaint();
    }

    public void initjmenu() {
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的选项
        JMenu functionmenu = new JMenu("功能");
        JMenu aboutmenu = new JMenu("关于我们");


        //创建选项下面的条目
//        JMenuItem changeimage = new JMenuItem("更换图片");

        //绑定动作监听事件
        replay.addActionListener(this);
        relogin.addActionListener(this);
        closegame.addActionListener(this);
        Publicaccount.addActionListener(this);
        //将条目添加到选项中
//        functionmenu.add(changeimage);
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
        this.setSize(603, 680);
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

        //给整个界面添加键盘监听方法
        this.addKeyListener(this);
    }
    public boolean judge_win(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win_data[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //查看完整图片
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {

            //变成完整图片
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            //添加背景图片
            JLabel jLabel_back = new JLabel(new ImageIcon("..\\JigsawPuzzle\\image\\background.png"));
            jLabel_back.setBounds(40, 40, 508, 560);//设置大小和放置位置
            this.getContentPane().add(jLabel_back);

            //最后一定要刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //如果胜利了，就不能再移动了
        if(judge_win())return;;

        int code = e.getKeyCode();
        if (code == 38) {
            if (blank_x == 3) {
                return;
            } else {
                data[blank_x][blank_y] = data[blank_x + 1][blank_y];
                data[blank_x + 1][blank_y] = 0;
                blank_x++;
                temp++;
                initimage();
            }
        } else if (code == 40) {
            if (blank_x == 0) {
                return;
            } else {
                data[blank_x][blank_y] = data[blank_x - 1][blank_y];
                data[blank_x - 1][blank_y] = 0;
                blank_x--;
                temp++;
                initimage();
            }
        } else if (code == 37) {
            if (blank_y == 3) {
                return;
            } else {
                data[blank_x][blank_y] = data[blank_x][blank_y + 1];
                data[blank_x][blank_y + 1] = 0;
                blank_y++;
                temp++;
                initimage();
            }
        } else if (code == 39) {
            if (blank_y == 0) {
                return;
            } else {
                data[blank_x][blank_y] = data[blank_x][blank_y - 1];
                data[blank_x][blank_y - 1] = 0;
                blank_y--;
                temp++;
                initimage();
            }
        } else if (code == 65) {
            initimage();
        } else if (code == 87) {
           data=new int[ ][]
                   {
                   {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
                   };
        }
        initimage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if(obj.equals(replay)){
            System.out.println("重新游戏");
        } else if (obj.equals(relogin)) {
            System.out.println("重新登录");
        }else if(obj.equals(closegame)){
            System.out.println("关闭游戏");
        }else if(obj.equals(Publicaccount)){
            System.out.println("公众号");
        }
    }
}
