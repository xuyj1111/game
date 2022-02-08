package xu.game.okay.zoldCode.page.users;


import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2020-03-07-12:37
 */
public class DefinedPage extends JPanel {
//    public String username = null;
//    private int x = 0, y = 0;
//    private int dian_x[] = new int[10];                 //画多边形时临时存的点
//    private int dian_y[] = new int[10];
//    private int number = 0;                             //当前页面花了多少图形
//    private int num = 0;                                //当前按下的是第几下
//    private int clicknum = 0;                           //判断单击双击
//    private int moo = 0;                                //画图的状态
//    private int shan = 0;                               //黑点闪烁
//    private int ii = 0, jj = 0;                         //记录鼠标的坐标（作清除用）
//    private int jii = 0, jjj = 0;                       //辅助作用
//    private boolean pan = false;                        //判断鼠标位置能不能选中
//    private int whitch = 0;                              //点击的图形是第几个
//    int nguan = 0;
//    public Timer timer = null;
//    JdbcConfig instance = JdbcConfig.getInstance();
//
//    public DefinedPage(String username) {
//        this.username = username;
//        setLayout(null);
//
//
//
//        add(back);
//
//
//        add(delete);
//
//
//
//        add(ok);
//
//
//
//        add(start);
//
//
//
//        add(menu);
//
//
//        add(question_icon);
//
//        mouse(back, delete, ok, start, menu, question_icon);
//
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
//                x = point.x - 611;
//                y = point.y - 55;
//                shan++;
//                shan %= 6;
//                repaint();
//            }
//        }, 0, 50);
//    }

//    public void mouse(JButton back, JButton delete, JButton ok,
//                      JButton start, JButton menu, JButton question_icon) {
//        this.addMouseListener(new MouseAdapter() {
//            public void o_or_t(int clicknum) {                    //
//                if (x >= 100 && x <= 700 && y >= 50 && y <= 850) {
//                    int zhix, zhiy;
//                    zhix = (x - 100) % 40;
//                    zhiy = (y - 50) % 40;
//                    if (zhix <= 15 && zhiy <= 15) {
//                        int i, j;
//                        i = (x - 100 - zhix) / 40;
//                        j = (y - 50 - zhiy) / 40;
//                        if (clicknum == 1) {
//                            for (int z = 0; z < 10; z++) {
//                                if (dian_x[z] == 40 * i + 100 && dian_y[z] == 40 * j + 50) {     //两个点在同一个位置
//                                    if (z == 0 && dian_x[z + 1] == 0) {               //清除
//                                        dian_x[0] = dian_y[0] = 0;
//                                    } else if (z == 1 && dian_x[z + 1] == 0) {          //线
//                                        fuzhi(1);
//                                    } else {                                            //多边形
//                                        fuzhi(3);
//                                    }
//                                    break;
//                                }
//                                if (z == 9) break;                  //十个点了，点不了了
//                                if (dian_x[z] == 0) {               //给点赋值
//                                    dian_x[z] = 40 * i + 100;
//                                    dian_y[z] = 40 * j + 50;
//                                    break;
//                                }
//                            }
//                        } else if (clicknum == 2) {                 //圆
//                            dian_x[0] = 40 * i + 100;
//                            dian_y[0] = 40 * j + 50;
//                            dian_x[1] = 80;
//                            fuzhi(2);
//                        }
//                    }
//                }
//            }
//
//            public void mouseClicked(MouseEvent e) {        //鼠标点击
//                clicknum = e.getClickCount();
//                if (clicknum == 1 && pan == false) {
//                    java.util.Timer timer = new Timer();
//                    timer.schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//                            num++;
//                            o_or_t(clicknum);
//                        }
//                    }, 350);
//                }
//                if (clicknum == 1 && pan == true) {
//                    panduan();
//                    if (e.getButton() == MouseEvent.BUTTON1) {
//                        String string;
//                        int zhi;
//                        string = instance.query("select shuxing from biao4 where number = "
//                                + (whitch + 1) + ";");
//                        zhi = Integer.valueOf(string) + 1;
//                        if (zhi == 5) zhi = 1;
//                        instance.update("update biao4 set shuxing = " + zhi
//                                + " where number = " + (whitch + 1) + ";");
//                        moo = 2;
//                    }
//                    if (e.getButton() == MouseEvent.BUTTON3) {
//                        String string = null;
//                        string = instance.query("select tuxing from biao4 where number = "
//                                + (whitch + 1) + ";");
//                        if (string.equals("2")) {             //圆
//                            string = instance.query("select x2 from biao4 where number = "
//                                    + (whitch + 1) + ";");
//                            if (string.equals("240"))
//                                instance.update("update biao4 set x2 = 80 where number = " + (whitch + 1) + ";");
//                            else
//                                instance.update("update biao4 set x2 = " + (Integer.valueOf(string) + 80) + " where number = " + (whitch + 1) + ";");
//                            moo = 3;
//                        }
//                    }
//                }
//
//            }
//        });
//        back.addActionListener(e -> {
//            Main.user_choose();
//        });
//        delete.addActionListener(e -> {
//            instance.update("delete from biao4 where number = " + (whitch + 1) + ";");
//            for (int i = 0; i < 10; i++) dian_x[i] = dian_y[i] = 0;
//            num = 0;
//            pan = false;
//            moo = 3;
//        });
//        ok.addActionListener(e -> {
//            if (number > 0) {
//                nguan = 0;
//                while (true) {
//                    String string;
//                    nguan++;
//                    string = instance.query("select nguan from biao3 where name = '" + username
//                            + "' AND nguan = " + nguan + ";");
//                    if (string == null)
//                        break;
//                }
//                if (nguan <= 20) {
//                    instance.update("INSERT INTO biao3 (tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 ) " +
//                            "select tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 from biao4;");
//                    instance.update("update biao3 set name = '" + username + "' where name is null");
//                    instance.update("update biao3 set nguan = " + nguan + " where nguan is null");
//                }
//                instance.update("delete from biao4 where number >0;");
//                instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//                number = 0;
//                pan = false;
//                moo = 3;
//            } else {
//                for (int i = 0; i < 10; i++) dian_x[i] = dian_y[i] = 0;
//                pan = false;
//                num = number = moo = 3;
//            }
//        });
//        start.addActionListener(e -> {
//            if (number > 0) {
//                for (int i = 0; i < 10; i++) dian_x[i] = dian_y[i] = 0;
//                num = number = moo = 0;
//                timer.cancel();
//                timer = null;
//                pan = false;
//                nguan = 0;
//                while (true) {
//                    String string;
//                    nguan++;
//                    string = instance.query("select nguan from biao3 where name = '" + username
//                            + "' AND nguan = " + nguan + ";");
//                    if (string == null)
//                        break;
//                }
//                if (nguan <= 20) {
//                    instance.update("INSERT INTO biao3 (tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 ) " +
//                            "select tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 from biao4;");
//                    instance.update("update biao3 set name = '" + username + "' where name is null");
//                    instance.update("update biao3 set nguan = " + nguan + " where nguan is null");
//                }
//                instance.update("delete from biao4 where number >0;");
//                instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//                Main.guan = 0;
//                Main.nguan = nguan;
//                Main.user_gametime();
//            } else {
//                for (int i = 0; i < 10; i++) dian_x[i] = dian_y[i] = 0;
//                pan = false;
//                num = number = moo = 3;
//            }
//        });
//        menu.addActionListener(e -> {
//            Main.user_defined_menu();
//        });
//        question_icon.addActionListener(e -> {
//            File file = new File("图标/说明.txt");
//            try {
//                Desktop.getDesktop().open(file);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//    }
//
//    public boolean panduan() {
//        String string1 = null, string2;                         //判断当前鼠标位置能否。。。
//        int xx[] = new int[10];
//        int yy[] = new int[10];
//        for (int i = 0; i < number; i++) {
//            for (int j = 0; j < 10; j++) {
//                string1 = instance.query("select X" + (j + 1)
//                        + " from biao4 where number = " + (i + 1) + ";");
//                string2 = instance.query("select y" + (j + 1)
//                        + " from biao4 where number = " + (i + 1) + ";");
//                if (string1 != null) {
//                    xx[j] = Integer.valueOf(string1) + 5;
//                    yy[j] = Integer.valueOf(string2) + 5;
//                }
//            }
//            if (string1 != null) {
//                if (xx[1] > 5 && yy[1] == 5) {              //圆
//                    if (Math.abs(x - xx[0]) <= (xx[1] - 5) / 2 && Math.abs(y - yy[0]) <= (xx[1] - 5) / 2) {
//                        for (int j = 0; j < 10; j++) xx[j] = yy[j] = 0;
//                        whitch = i;
//                        return true;
//                    }
//                    for (int j = 0; j < 10; j++) xx[j] = yy[j] = 0;
//                } else {                                    //多边形
//                    rayCast ray = new rayCast();
//                    ray.rayCastadd(xx, yy, x, y, Main.gametimePage, i);
//                    for (int j = 0; j < 10; j++) xx[j] = yy[j] = 0;
//                    if (ray.rayCasting(false)) {
//                        whitch = i;
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public void fuzhi(int tuxing) {
//        //将一个图形存在数据库biao4
//        instance.update("INSERT INTO biao4 (tuxing,shuxing) VALUES ("
//                + tuxing + ",1); ");
//        for (int i = 0; i < 10; i++) {
//            instance.update("update biao4 set x" + (i + 1) + " = "
//                    + dian_x[i] + " where number = " + (number + 1) + ";");
//            instance.update("update biao4 set y" + (i + 1) + " = "
//                    + dian_y[i] + " where number = " + (number + 1) + ";");
//        }
//        for (int i = 0; i < 10; i++) dian_x[i] = dian_y[i] = 0;
//        moo = 2;
//        num = 0;
//        number++;
//    }
//
//    public void paint(Graphics gr) {
//        Graphics2D g = (Graphics2D) gr;
//        g.setBackground(Color.white);
//        g.clearRect(0, 0, 50, 50);
//        if (moo == 0) {                     //初始界面
//            paint1(g);
//            moo = 1;
//        } else if (moo == 1) {              //其他
//            paint2(g);
//        } else if (moo == 2) {              //画一下图形
//            paint3(g);
//            if (number > 0)
//                pan = panduan();
//            moo = 1;
//        } else if (moo == 3) {
//            paint1(g);
//            paint3(g);
//            moo = 1;
//        }
//    }
//
//    public void paint1(Graphics2D g) {
//        g.setBackground(Color.white);
//        g.clearRect(0, 0, getWidth(), getHeight());
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 20; j++) {
//                g.setColor(Color.lightGray);
//                g.fillOval(40 * i + 100, 40 * j + 50, 10, 10);
//            }
//        }
//        super.paintComponents(g);
//    }
//
//    public void paint2(Graphics2D g) {
//        g.setColor(Color.black);
//        for (int i = 0; i < 10; i++) {
//            if (dian_y[i] != 0)
//                g.fillOval(dian_x[i], dian_y[i], 10, 10);
//            if (dian_x[i] != 0 && dian_y[i + 1] != 0 && i < 9) {
//                g.drawLine(dian_x[i] + 5, dian_y[i] + 5, dian_x[i + 1] + 5, dian_y[i + 1] + 5);
//            }
//        }
//        if (x >= 100 && x <= 680 && y >= 50 && y <= 820) {
//            int zhix, zhiy;
//            zhix = (x - 100) % 40;
//            zhiy = (y - 50) % 40;
//            if (zhix <= 15 && zhiy <= 15) {
//                int i, j;
//                i = (x - 100 - zhix) / 40;
//                j = (y - 50 - zhiy) / 40;
//                if (jii != i && jjj != j) {
//                    if (number > 0)
//                        pan = panduan();
//                    jii = i;
//                    jjj = j;
//                }
//                if (pan == false) {
//                    if ((num > 0 && (dian_x[num - 1] != 40 * i + 100 || dian_y[num - 1] != 40 * j + 50)) || num == 0) {
//                        if (shan < 3) g.setColor(Color.black);
//                        else g.setColor(Color.lightGray);
//                    }
//                    g.fillOval(40 * i + 100, 40 * j + 50, 10, 10);
//
//                    if (ii != i || jj != j) {
//                        g.setColor(Color.lightGray);
//                        g.fillOval(40 * ii + 100, 40 * jj + 50, 10, 10);
//                        ii = i;
//                        jj = j;
//                    }
//                }
//                if (pan == true) ii = jj = 0;
//            }
//        }
//    }
//
//    public void paint3(Graphics2D g) {
//        for (int i = 0; i < number; i++) {
//            String string1, string2, string3 = null, string4;
//            int x[] = new int[10];
//            int y[] = new int[10];
//            int ji = 0;
//            for (int j = 0; j < 10; j++) {
//                string3 = instance.query("select X" + (j + 1)
//                        + " from biao4 where number = " + (i + 1) + ";");
//                string4 = instance.query("select y" + (j + 1)
//                        + " from biao4 where number = " + (i + 1) + ";");
//                if (string3 != null) {
//
//                    x[j] = Integer.valueOf(string3) + 5;
//                    y[j] = Integer.valueOf(string4) + 5;
//                    if (y[j] > 5) ji = j;
//                }
//            }
//
//            if (string3 != null) {
//
//                for (int j = 0; j < ji + 1; j++) {
//                    g.setColor(Color.lightGray);
//                    g.fillOval(x[j] - 5, y[j] - 5, 10, 10);
//                }
//
//                string1 = instance.query("select tuxing from biao4 where number = "
//                        + (i + 1) + ";");
//                string2 = instance.query("select shuxing from biao4 where number = "
//                        + (i + 1) + ";");
//                if (string2.equals("1")) g.setColor(Color.gray);
//                else if (string2.equals("2")) g.setColor(Color.lightGray);
//                else if (string2.equals("3")) g.setColor(Color.black);
//                else if (string2.equals("4")) {
//                    g.setColor(Color.white);
//                }
//
//                if (string1.equals("1")) {                //线
//                    g.drawLine(x[0], y[0], x[1], y[1]);
//                } else if (string1.equals("2")) {                //圆
//                    if (string2.equals("4")) {
//                        g.fillOval(x[0] - (x[1] / 2), y[0] - (x[1] / 2), x[1], x[1]);
//                        g.setColor(Color.black);
//                        g.drawOval(x[0] - ((x[1] - 2) / 2), y[0] - ((x[1] - 2) / 2), x[1] - 2, x[1] - 2);
//                    } else
//                        g.fillOval(x[0] - x[1] / 2, y[0] - x[1] / 2, x[1], x[1]);
//                } else if (string1.equals("3")) {                //多边形
//                    if (string2.equals("4")) {
//                        g.fillPolygon(x, y, ji + 1);
//                        g.setColor(Color.black);
//                        g.drawPolygon(x, y, ji + 1);
//                    } else
//                        g.fillPolygon(x, y, ji + 1);
//                }
//            }
//        }
//    }
}
