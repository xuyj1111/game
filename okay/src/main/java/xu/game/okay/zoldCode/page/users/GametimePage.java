package xu.game.okay.zoldCode.page.users;


import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2019-10-26-15:27
 */
public class GametimePage extends JPanel {
//    public String username;
//    public int guan;                                //闯关模式第几关，为0时为自定义模式
//    public int nguan;                               //自定义第几关，为0时为闯关模式
//    private int number;                             //当前多少个图形
//    private int mouse_x;                            //鼠标的坐标x
//    private int mouse_y;                            //鼠标的坐标y
//    private double start_x, start_y;                    //线的起始坐标x、y
//    private int cun_x[];                            //存当前关 所有图形的坐标x
//    private int cun_y[];                            //存当前关 所有图形的坐标x
//    private int fucun_x[];
//    private int fucun_y[];
//    private int cun_shu[];                          //存当前关 所有图形的属性
//    private int fucun_shu[];
//    public int moo = 100;                                //状态
//    private double qingx, qingy;                       //清除的坐标
//    private double ball_x, ball_y;                  //大球坐标
//    private int end_x, end_y;                       //线的结束坐标x、y
//    private double moving_x, moving_y;              //每次图形移动多少xy
//    private int dangtu[] = new int[3];              //第几个、什么图形、什么属性
//    private int biaoji;                             //标记进入浅灰图形
//
//    public double fan_tan_x, fan_tan_y;
//    public double fan_tan_xx, fan_tan_yy;
//    public rayCast ray = null;
//    private Timer timer;
//    JdbcConfig instance = JdbcConfig.getInstance();
//
//    JButton back = new JButton();
//    JButton menu = new JButton();
//    JButton question_icon = new JButton();
//
//    public GametimePage(String username, int guan, int nguan) {
//        this.username = username;
//        this.guan = guan;
//        this.nguan = nguan;
//        setLayout(null);
//
//        back.setForeground(Color.black);
//        back.setIcon(new ImageIcon("图标/返回.jpg"));
//        back.setBounds(190, 850, 50, 50);
//        back.setBorderPainted(false);
//        back.setVisible(false);
//        add(back);
//
//        menu.setForeground(Color.black);
//        menu.setIcon(new ImageIcon("图标/菜单.jpg"));
//        menu.setBounds(530, 850, 50, 50);
//        menu.setBorderPainted(false);
//        menu.setVisible(false);
//        add(menu);
//
//        if (Main.admin == false) {
//            question_icon.setForeground(Color.black);
//            question_icon.setIcon(new ImageIcon("图标/问号.jpg"));
//            question_icon.setBounds(680, 70, 30, 30);
//            question_icon.setBorderPainted(false);
//            question_icon.setVisible(false);
//            add(question_icon);
//        }
//
//        mouse(back, menu, question_icon);
//        caozuo();
//    }
//
//    public void caozuo() {
//        String string;
//        timer = new Timer();
//        TimerTask t = new TimerTask() {
//
//            @Override
//            public void run() {
//                Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
//                mouse_x = point.x - 611;
//                mouse_y = point.y - 55;
//                if (moo >= 3)
//                    repaint();
//            }
//        };
//        timer.scheduleAtFixedRate(t, 0, 10);
//        if (guan == 0) {      //自定义模式
//            instance.update("INSERT INTO biao4 (tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10) " +
//                    "select tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 " +
//                    "from biao3 where biao3.name = '" + username + "' AND biao3.nguan = " + nguan + ";");
//        } else {              //闯关模式
//            instance.update("INSERT INTO biao4 (tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10) " +
//                    "select tuxing,shuxing,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 " +
//                    "from biao2 where biao2.guan = " + guan + ";");
//        }
//        string = instance.query("SELECT count(*) FROM biao4;");
//        number = Integer.valueOf(string);
//        cun_x = new int[10 * number];
//        cun_y = new int[10 * number];
//        fucun_x = new int[10 * number];
//        fucun_y = new int[10 * number];
//        cun_shu = new int[number];
//        fucun_shu = new int[number];
//        for (int i = 0; i < number; i++) {
//            string = instance.query("select shuxing from biao4 where number = " + (i + 1) + ";");
//            cun_shu[i] = fucun_shu[i] = Integer.valueOf(string);
//            for (int j = 0; j < 10; j++) {
//                string = instance.query("select X" + (j + 1)
//                        + " from biao4 where number = " + (i + 1) + ";");
//                cun_x[i * 10 + j] = fucun_x[i * 10 + j] = Integer.valueOf(string) + 5;
//                string = instance.query("select y" + (j + 1)
//                        + " from biao4 where number = " + (i + 1) + ";");
//                cun_y[i * 10 + j] = fucun_y[i * 10 + j] = Integer.valueOf(string) + 5;
//            }
//        }
//        moo = 0;
//    }
//
//    public void mouse(JButton back, JButton menu, JButton question_icon) {
//        this.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {        //鼠标点击
//                if (e.getButton() == MouseEvent.BUTTON3) {
//                    if (moo == 1 || moo >= 3) {
//                        moo = 2;
//                        back.setVisible(true);
//                        menu.setVisible(true);
//                        question_icon.setVisible(true);
//                        repaint();
//                    } else if (moo == 2) {
//                        moo = 1;
//                        back.setVisible(false);
//                        menu.setVisible(false);
//                        question_icon.setVisible(false);
//                        repaint();
//                    }
//                }
//            }
//
//            public void mousePressed(MouseEvent e) {            //鼠标按下
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    back.setVisible(false);
//                    menu.setVisible(false);
//                    question_icon.setVisible(false);
//                    repaint();
//                    moo = 7;
//                }
//            }
//
//            public void mouseReleased(MouseEvent e) {            //鼠标松开
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    moo = 5;
//                }
//            }
//        });
//        back.addActionListener(e -> {
//            instance.update("delete from biao4 where number > 0;");
//            instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//            if (Main.admin == false)
//                Main.user_choose();
//            else {
//                if (guan > 0)
//                    Main.admin_choose();
//                else Main.admin_manageUsersEdit(username);
//                Main.guan = 0;
//                Main.nguan = 0;
//            }
//        });
//        menu.addActionListener(e -> {
//            instance.update("delete from biao4 where number > 0;");
//            instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//            if (Main.admin == false) {
//                if (nguan == 0) {
//                    Main.user_gametime_menu();
//                } else {
//                    Main.user_defined_menu();
//                }
//            } else {
//                if (guan > 0)
//                    Main.admin_manageGametimeMenu();
//                else Main.admin_manageDefinedMenu();
//                Main.guan = 0;
//                Main.nguan = 0;
//            }
//        });
//
//        if (Main.admin == false) {
//            question_icon.addActionListener(e -> {
//                File file = new File("图标/说明.txt");
//                try {
//                    Desktop.getDesktop().open(file);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            });
//        }
//    }
//
//    public boolean panduan(int mouse_x, int mouse_y) {                      //判断当前鼠标位置能否。。。
//        boolean fan = false;
//        int bj = 0;
//        fan_tan_x = fan_tan_y = 0;
//        for (int i = 0; i < 4; i++) {
//            if (i == 0) {
//                mouse_x--;
//                mouse_y--;
//            } else if (i == 1) mouse_x += 10;
//            else if (i == 2) mouse_y += 10;
//            else if (i == 3) mouse_x -= 10;
//            for (int j = 0; j < number; j++) {
//                if (cun_x[j * 10 + 1] > 5 && cun_y[j * 10 + 1] == 5 && fan == false) {              //圆
//                    if (Math.abs(mouse_x - cun_x[j * 10]) <= (cun_x[j * 10 + 1] - 5) / 2 &&
//                            Math.abs(mouse_y - cun_y[j * 10]) <= (cun_x[j * 10 + 1] - 5) / 2) {
//                        dangtu[2] = cun_shu[j];
//                        dangtu[0] = j;
//                        dangtu[1] = 2;
//                        if (moo == 6) {
//                            if (cun_shu[j] != 2) {        //不是浅灰
//                                fan = true;
//                                fan_tan_x = mouse_x;
//                                fan_tan_y = mouse_y;
//                            } else bj = 1;                //浅灰
//                        } else {
//                            fan = true;
//                            fan_tan_x = mouse_x;
//                            fan_tan_y = mouse_y;
//                        }
//                    }
//                } else if (cun_x[j * 10] > 5 && cun_x[j * 10 + 1] > 5 && cun_y[j * 10] > 5 && cun_y[j * 10 + 1] > 5 && cun_x[j * 10 + 2] == 5) {
//                    int zhix = 0, zhiy = 0;
//                    if (i == 0) {
//                        zhix = mouse_x;
//                        zhiy = mouse_y;
//                    } else if (i == 1) {
//                        zhix = mouse_x - 10;
//                        zhiy = mouse_y;
//                    } else if (i == 2) {
//                        zhix = mouse_x;
//                        zhiy = mouse_y - 10;
//                    } else if (i == 3) {
//                        zhix = mouse_x + 10;
//                        zhiy = mouse_y;
//                    }
//                    for (int z = 0; z < 10 && fan == false; z++) {
//                        if (i == 0) zhix++;
//                        else if (i == 1) zhiy++;
//                        else if (i == 2) zhix--;
//                        else if (i == 2) zhiy--;
//                        if (((zhix - cun_x[j * 10]) * (cun_y[j * 10] - cun_y[j * 10 + 1])) == ((cun_x[j * 10] - cun_x[j * 10 + 1]) * (zhiy - cun_y[j * 10]))
//                                && (zhix >= Math.min(cun_x[j * 10], cun_x[j * 10 + 1]) && zhix <= Math.max(cun_x[j * 10], cun_x[j * 10 + 1]))
//                                && ((zhiy >= Math.min(cun_y[j * 10], cun_y[j * 10 + 1])) && (zhiy <= Math.max(cun_y[j * 10], cun_y[j * 10 + 1])))) {
//                            dangtu[0] = j;
//                            dangtu[1] = 0;
//                            dangtu[2] = cun_shu[j];
//                            fan = true;
//                        }
//                    }
//                } else {                                    //多边形
//                    int xx[] = new int[10];
//                    int yy[] = new int[10];
//                    for (int z = 0; z < 10; z++) {
//                        xx[z] = cun_x[j * 10 + z];
//                        yy[z] = cun_y[j * 10 + z];
//                    }
//                    if (ray == null)
//                        ray = new rayCast();
//                    ray.rayCastadd(xx, yy, mouse_x, mouse_y, Main.gametimePage, j);
//                    if (ray.rayCasting(true)) {
//                        dangtu[2] = cun_shu[j];
//                        dangtu[0] = j;
//                        dangtu[1] = 1;
//                        if (moo == 6) {
//                            if (cun_shu[j] != 2) {           //不是浅灰
//                                fan = true;
//                                fan_tan_x = mouse_x;
//                                fan_tan_y = mouse_y;
//                            } else bj = 1;                  //浅灰
//                        } else {
//                            fan = true;
//                            fan_tan_x = mouse_x;
//                            fan_tan_y = mouse_y;
//                        }
//                        ray.rayCasting(true);
//                    }
//                }
//            }
//        }
//        if (moo == 6) {
//            if (bj == 1) biaoji = 1;
//            else if (biaoji == 1) biaoji = 2;
//        }
//        return fan;
//    }
//
//    public void paint(Graphics gr) {
//        Graphics2D g = (Graphics2D) gr;
//        if (moo == 0 || moo == 7) {
//            if (moo == 7) {
//                for (int i = 0; i < number * 10; i++) {
//                    cun_x[i] = fucun_x[i];
//                    cun_y[i] = fucun_y[i];
//                }
//                for (int i = 0; i < number; i++) cun_shu[i] = fucun_shu[i];
//                fan_tan_x = fan_tan_y = fan_tan_xx = fan_tan_yy = 0;
//            }
//            g.setBackground(Color.white);
//            g.clearRect(0, 0, getWidth(), getHeight());
//            drawtu(g);
//            if (moo == 0)
//                moo = 1;
//            else moo = 3;
//        }
//        if (moo > 0) {
//            g.setBackground(Color.white);
//            g.clearRect(0, 850, getWidth(), getHeight());
//            g.clearRect(680, 70, 710, 100);
//
//            if (moo == 3) {
//                start_x = mouse_x;
//                start_y = mouse_y;
//                moo = 4;
//            }
//            if (moo == 4) {
//                drawline(start_x, start_y, mouse_x, mouse_y, g);
//            }
//            if (moo == 5) {
//                qingline(g);
//                ball_x = qingx = start_x - 5;
//                ball_y = qingy = start_y - 5;
//                end_x = mouse_x;
//                end_y = mouse_y;
//                jisuan(start_x, start_y, end_x, end_y);
//                moo = 6;
//            }
//            if (moo == 6) {
//                for (int i = 0; i < 5 && moo == 6 && timer != null; i++)
//                    ballmoving(g);
//            }
//        }
//        if (moo < 3)
//            super.paintComponents(g);
//    }
//
//    public void drawtu(Graphics2D g) {
//        for (int i = 0; i < number; i++) {
//            int string1, string2, string3 = 0, string4;
//            int x[] = new int[10];
//            int y[] = new int[10];
//            int ji = 0;
//            for (int j = 0; j < 10; j++) {
//                string3 = cun_x[10 * i + j];
//                string4 = cun_y[10 * i + j];
//                if (string3 != 0) {
//
//                    x[j] = string3;
//                    y[j] = string4;
//                    if (y[j] > 5) ji = j;
//                }
//            }
//
//            if (string3 != 0) {
//
//                if (cun_x[10 * i + 1] > 5 && cun_y[10 * i + 1] > 5 && cun_x[10 * i + 2] == 5) { //线
//                    string1 = 1;
//                } else if (cun_x[10 * i + 1] > 5 && cun_y[10 * i + 1] == 5) { //圆
//                    string1 = 2;
//                } else {                          //多边形
//                    string1 = 3;
//                }
//                string2 = cun_shu[i];
//                if (string2 == 1) g.setColor(Color.gray);
//                else if (string2 == 2) g.setColor(Color.lightGray);
//                else if (string2 == 3) g.setColor(Color.black);
//                else if (string2 == 4) {
//                    g.setColor(Color.white);
//                }
//
//                if (string1 == 1) {                //线
//                    g.drawLine(x[0], y[0], x[1], y[1]);
//                } else if (string1 == 2) {                //圆
//                    if (string2 == 4) {
//                        g.fillOval(x[0] - (x[1] / 2), y[0] - (x[1] / 2), x[1], x[1]);
//                        g.setColor(Color.black);
//                        g.drawOval(x[0] - ((x[1] - 2) / 2), y[0] - ((x[1] - 2) / 2), x[1] - 2, x[1] - 2);
//                    } else
//                        g.fillOval(x[0] - x[1] / 2, y[0] - x[1] / 2, x[1], x[1]);
//                } else if (string1 == 3) {                //多边形
//                    if (string2 == 4) {
//                        g.fillPolygon(x, y, ji + 1);
//                        g.setColor(Color.black);
//                        g.drawPolygon(x, y, ji + 1);
//                    } else
//                        g.fillPolygon(x, y, ji + 1);
//                }
//            }
//        }
//    }
//
//    public void drawline(double start_x, double start_y, int mouse_x, int mouse_y, Graphics2D g) {
//        double zhi1, zhi2;
//        zhi1 = start_x - mouse_x;
//        zhi2 = start_y - mouse_y;
//        qingline(g);
//        qingx = mouse_x;
//        qingy = mouse_y;
//        g.setColor(Color.BLACK);
//        for (int i = 0; i <= 6; i++) {
//            int wh;
//            if (i == 0) wh = 10;
//            else wh = 8;
//            if (zhi1 == 0 || zhi2 == 0) {
//                if (zhi1 == 0) {
//                    if (!panduan((int) start_x - 5, (int) (start_y - (zhi2 / 6) * i - 5)))
//                        g.fillOval((int) start_x - 5, (int) (start_y - (zhi2 / 6) * i - 5), wh, wh);
//                } else {
//                    if (!panduan((int) (start_x - (zhi1 / 6) * i - 5), (int) start_y - 5))
//                        g.fillOval((int) (start_x - (zhi1 / 6) * i - 5), (int) start_y - 5, wh, wh);
//                }
//            } else {
//                if (!panduan((int) (start_x - (zhi1 / 6) * i - 5), (int) (start_y - (zhi2 / 6) * i - 5)))
//                    g.fillOval((int) (start_x - (zhi1 / 6) * i - 5), (int) (start_y - (zhi2 / 6) * i - 5), wh, wh);
//            }
//        }
//    }
//
//    public void qingline(Graphics2D g) {
//        double zhi1, zhi2;
//        if (qingx != 0 || qingy != 0) {
//            zhi1 = start_x - qingx;
//            zhi2 = start_y - qingy;
//            g.setColor(Color.white);
//            for (int i = 0; i <= 6; i++) {
//                int wh;
//                if (i == 0) wh = 10;
//                else wh = 8;
//                if (zhi1 == 0 || zhi2 == 0) {
//                    if (zhi1 == 0) {
//                        if (!panduan((int) start_x - 5, (int) (start_y - (zhi2 / 6) * i - 5)))
//                            g.fillOval((int) start_x - 5, (int) (start_y - (zhi2 / 6) * i - 5), wh, wh);
//                    } else {
//                        if (!panduan((int) (start_x - (zhi1 / 6) * i - 5), (int) start_y - 5))
//                            g.fillOval((int) (start_x - (zhi1 / 6) * i - 5), (int) start_y - 5, wh, wh);
//                    }
//                } else {
//                    if (!panduan((int) (start_x - (zhi1 / 6) * i - 5), (int) (start_y - (zhi2 / 6) * i - 5)))
//                        g.fillOval((int) (start_x - (zhi1 / 6) * i - 5), (int) (start_y - (zhi2 / 6) * i - 5), wh, wh);
//                }
//            }
//        }
//    }
//
//    public void ballmoving(Graphics2D g) {
//        boolean pd;
//        g.setColor(Color.white);
//        g.fillOval((int) qingx, (int) qingy, 10, 10);
//        pd = !panduan((int) ball_x, (int) ball_y);
//        if (!pd || biaoji == 1) {
//            if (dangtu[2] == 1) {                           //深灰
//                if (dangtu[1] == 0) {                       //线
//                    g.setColor(Color.white);
//                    g.drawLine(cun_x[10 * dangtu[0]], cun_y[10 * dangtu[0]], cun_x[10 * dangtu[0] + 1], cun_y[10 * dangtu[0] + 1]);
//                    cun_x[10 * dangtu[0]] = cun_x[10 * dangtu[0] + 1] = 0;
//                    cun_y[10 * dangtu[0]] = cun_y[10 * dangtu[0] + 1] = 0;
//                } else
//                    fantan(g);
//            } else if (dangtu[2] == 2) {                    //浅灰
//                g.setColor(Color.lightGray);
//                if (dangtu[1] == 1) {
//                    int i;
//                    int x[], y[];
//                    for (i = 0; i < 10; i++) {
//                        if (cun_x[10 * dangtu[0] + i] <= 5) break;
//                    }
//                    x = new int[i];
//                    y = new int[i];
//                    for (int j = 0; j < i; j++) {
//                        x[j] = cun_x[10 * dangtu[0] + j];
//                        y[j] = cun_y[10 * dangtu[0] + j];
//                    }
//                    g.fillPolygon(x, y, i);
//                }
//                if (dangtu[1] == 2)
//                    g.fillOval(cun_x[10 * dangtu[0]] - cun_x[10 * dangtu[0] + 1] / 2, cun_y[10 * dangtu[0]] - cun_x[10 * dangtu[0] + 1] / 2, cun_x[10 * dangtu[0] + 1], cun_x[10 * dangtu[0] + 1]);
//            } else if (dangtu[2] == 3) {                   //黑色
//                fantan(g);
//            } else if (dangtu[2] == 4) {
//                for (int i = 0; i < number * 10; i++) {
//                    cun_x[i] = fucun_x[i];
//                    cun_y[i] = fucun_y[i];
//                }
//                for (int i = 0; i < number; i++) cun_shu[i] = fucun_shu[i];
//                fan_tan_x = fan_tan_y = fan_tan_xx = fan_tan_yy = 0;
//                moo = 0;
//                repaint();
//            }
//        }
//        if (pd) {
//
//            g.setColor(Color.black);
//            g.fillOval((int) ball_x, (int) ball_y, 10, 10);
//            qingx = (int) ball_x;
//            qingy = (int) ball_y;
//            ball_x += moving_x;
//            ball_y += moving_y;
//            if (biaoji == 2) {
//                g.setColor(Color.GRAY);
//                if (dangtu[1] == 1) {
//                    int i;
//                    int x[], y[];
//                    for (i = 0; i < 10; i++) {
//                        if (cun_x[10 * dangtu[0] + i] <= 5) break;
//                    }
//                    x = new int[i];
//                    y = new int[i];
//                    for (int j = 0; j < i; j++) {
//                        x[j] = cun_x[10 * dangtu[0] + j];
//                        y[j] = cun_y[10 * dangtu[0] + j];
//                    }
//                    g.fillPolygon(x, y, i);
//                }
//                if (dangtu[1] == 2)
//                    g.fillOval(cun_x[10 * dangtu[0]] - cun_x[10 * dangtu[0] + 1] / 2, cun_y[10 * dangtu[0]] - cun_x[10 * dangtu[0] + 1] / 2, cun_x[10 * dangtu[0] + 1], cun_x[10 * dangtu[0] + 1]);
//                cun_shu[dangtu[0]] = 1;
//                biaoji = 0;
//            }
//            if (ball_x < -10 || ball_y < -10 || ball_x > 800 || ball_y > 1000) {
//                int i;
//                for (i = 0; i < number; i++) {
//                    if (cun_shu[i] < 3 && cun_x[10 * i] != 0)
//                        break;
//                }
//                if (i == number) {               //清除完
//                    back.setVisible(false);
//                    menu.setVisible(false);
//                    question_icon.setVisible(false);
//                    timer = null;
//                    String guanSQL;
//                    guanSQL = instance.query("select guan from biao1 where name = '" + username + "';");
//                    instance.update("delete from biao4 where number > 0;");
//                    instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//
//                    if (Main.admin == false) {
//                        if (guan > 0) {
//                            if (guan < 20 && guan == Integer.valueOf(guanSQL))
//                                instance.update("update biao1 set guan = " + ++guan + " where name ='" + username + "';");
//                            else guan++;
//                        }
//                        if (guan == 0) {              //自定义模式
//                            Main.user_defined_menu();
//                        } else {                      //闯关
//                            if (guan == 21) {
//                                Main.user_gametime_menu();
//                            } else {
//                                if (Main.guan < Integer.valueOf(guanSQL))
//                                    Main.user_gametime_menu();
//                                else {
//                                    Main.num = guan;
//                                    Main.guan = guan;
//                                    Main.number();
//                                }
//                            }
//                        }
//                    } else {
//                        if (guan > 0)
//                            Main.admin_manageGametimeMenu();
//                        else Main.admin_manageDefinedMenu();
//                    }
//                } else {
//                    for (i = 0; i < number * 10; i++) {
//                        cun_x[i] = fucun_x[i];
//                        cun_y[i] = fucun_y[i];
//                    }
//                    for (i = 0; i < number; i++) cun_shu[i] = fucun_shu[i];
//                    fan_tan_x = fan_tan_y = fan_tan_xx = fan_tan_yy = 0;
//                    moo = 0;
//                    repaint();
//                }
//            }
//        }
//    }
//
//    public double fan_jiao(double x1, double y1, double x2, double y2) {
//
//        double x, y;
//        double yx_x, yx_y;
//        //*****************************
//        double distance;
//        double xD;
//        double mySin;
//        double degree;
//        //*****************************
//        x = x1;
//        y = y1;
//        yx_x = x2;
//        yx_y = y2;
//        distance = Math.sqrt(Math.pow(x - yx_x, 2) + Math.pow(y - yx_y, 2));
//        xD = x - yx_x;
//        mySin = Math.abs(xD) / distance;
//        if (x < yx_x) {
//            if (y < yx_y) {
//                degree = 360 - Math.asin(mySin) / Math.PI * 180;
//            } else {
//                degree = Math.asin(mySin) / Math.PI * 180 + 180;
//            }
//        } else {
//            if (y < yx_y) {
//                degree = Math.asin(mySin) / Math.PI * 180;
//            } else {
//                degree = 180 - Math.asin(mySin) / Math.PI * 180;
//            }
//        }
//        if (degree == 90 || degree == 270) {
//            return 90;
//        } else {
//            if (degree >= 0 && degree < 90) {
//                return -degree;
//            } else if (degree >= 180 && degree < 270) {
//                return -(degree - 180);
//            } else if (degree > 90 && degree < 180) {
//                return 90 - (degree - 90);
//            } else if (degree > 270 && degree < 360) {
//                return 90 - (degree - 270);
//            }
//        }
//        return 0;
//    }
//
//    public void fantan(Graphics2D g) {
//        double k1, k2;              //斜率
//        double zb1_x, zb1_y;        //交点坐标
//        double zb2_x = 0, zb2_y = 0;        //斜线上任意一点
//        double mouse_xx, mouse_yy;    //发射点
//        double end_x, end_y;        //结束点
//        double jiao = 0;                //斜线角度
//        double zhix, zhiy;          //辅助赋值
//        double coszhi, sinzhi;
//        ball_x -= moving_x;
//        ball_y -= moving_y;
//        mouse_xx = start_x;
//        mouse_yy = start_y;
//        zb1_x = ball_x + 5;
//        zb1_y = ball_y + 5;
//        if (dangtu[1] == 1) {               //多边形
//            zb2_x = fan_tan_xx - (fan_tan_x - (ball_x + 5));
//            zb2_y = fan_tan_yy - (fan_tan_y - (ball_y + 5));
//        } else if (dangtu[1] == 2) {         //圆
//            String zhi_x = null, zhi_y = null;
//            zhi_x = instance.query("select x1 from biao4 where number = " + (dangtu[0] + 1) + ";");
//            zhi_y = instance.query("select y1 from biao4 where number = " + (dangtu[0] + 1) + ";");
//            jiao = fan_jiao(zb1_x, zb1_y, Double.valueOf(zhi_x), Double.valueOf(zhi_y));
//        }
//
//        if (zb1_x == zb2_x || jiao == 90) {
//            end_x = mouse_xx;
//            end_y = zb1_y + (zb1_y - mouse_yy);
//        } else {
//            if (jiao == 0) {
//                k1 = (zb1_y - zb2_y) / (zb1_x - zb2_x);
//                k2 = (zb1_y - zb1_y) / (0.0 - zb1_x);
//                jiao = Math.toDegrees(Math.atan((k2 - k1) / (1 + k1 * k2)));
//            }
//            coszhi = (int) ((Math.cos(Math.toRadians(jiao))) * 1000000) / 1000000.0;
//            sinzhi = (int) ((Math.sin(Math.toRadians(jiao))) * 1000000) / 1000000.0;
//            zhix = mouse_xx;
//            zhiy = mouse_yy;
//            mouse_xx = (int) ((zhix * coszhi - zhiy * sinzhi) * 1000000) / 1000000.0;
//            mouse_yy = (int) ((zhiy * coszhi + zhix * sinzhi) * 1000000) / 1000000.0;
//            zhix = zb1_x;
//            zhiy = zb1_y;
//            zb1_x = (int) ((zhix * coszhi - zhiy * sinzhi) * 1000000) / 1000000.0;
//            zb1_y = (int) ((zhiy * coszhi + zhix * sinzhi) * 1000000) / 1000000.0;
//            end_x = zb1_x + (zb1_x - mouse_xx);
//            end_y = mouse_yy;
//            zhix = end_x;
//            zhiy = end_y;
//            end_x = (int) ((zhix * coszhi + zhiy * sinzhi) * 1000000) / 1000000.0;
//            end_y = (int) ((zhiy * coszhi - zhix * sinzhi) * 1000000) / 1000000.0;
//
//        }
//
//
//        if (dangtu[2] == 1) {            //深灰
//            g.setColor(Color.white);
//            if (dangtu[1] == 1) {                     //多边形
//                int i;
//                int x[], y[];
//                for (i = 0; i < 10; i++) {
//                    if (cun_x[10 * dangtu[0] + i] <= 5) break;
//                }
//                x = new int[i];
//                y = new int[i];
//                for (int j = 0; j < i; j++) {
//                    x[j] = cun_x[10 * dangtu[0] + j];
//                    cun_x[10 * dangtu[0] + j] = 0;
//                    y[j] = cun_y[10 * dangtu[0] + j];
//                    cun_y[10 * dangtu[0] + j] = 0;
//                }
//                g.fillPolygon(x, y, i);
//            } else if (dangtu[1] == 2) {               //圆
//                g.fillOval(cun_x[10 * dangtu[0]] - cun_x[10 * dangtu[0] + 1] / 2, cun_y[10 * dangtu[0]] - cun_x[10 * dangtu[0] + 1] / 2, cun_x[10 * dangtu[0] + 1], cun_x[10 * dangtu[0] + 1]);
//                cun_x[10 * dangtu[0]] = cun_x[10 * dangtu[0] + 1] = 0;
//                cun_y[10 * dangtu[0]] = 0;
//            }
//        }
//        start_x = ball_x + 5;
//        start_y = ball_y + 5;
//
//        jisuan(start_x, start_y, end_x, end_y);
//        fan_tan_x = fan_tan_y = fan_tan_xx = fan_tan_yy = 0;
//    }
//
//    public void jisuan(double start_x, double start_y, double end_x, double end_y) {
//        if (start_x != end_x && start_y != end_y) {
//            if (Math.abs(end_x - start_x) < Math.abs(end_y - start_y)) {
//                moving_x = (end_x - start_x) / (end_y - start_y);
//                moving_y = 1;
//            } else if (Math.abs(end_x - start_x) == Math.abs(end_y - start_y)) {
//                moving_x = moving_y = 1;
//            } else if (Math.abs(end_x - start_x) > Math.abs(end_y - start_y)) {
//                moving_x = 1;
//                moving_y = (end_y - start_y) / (end_x - start_x);
//            }
//        } else {
//            if (start_x == end_x) {
//                moving_x = 1;
//                moving_y = 0;
//            } else if (start_y == end_y) {
//                moving_x = 0;
//                moving_y = 1;
//            }
//        }
//        if ((start_x < end_x && moving_x < 0) || (start_x > end_x && moving_x > 0))
//            moving_x = -moving_x;
//        if ((start_y < end_y && moving_y < 0) || (start_y > end_y && moving_y > 0))
//            moving_y = -moving_y;
//
//    }
}
