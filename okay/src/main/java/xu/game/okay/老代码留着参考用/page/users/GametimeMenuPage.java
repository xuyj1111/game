package xu.game.okay.老代码留着参考用.page.users;

import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2020-03-07-15:47
 */
public class GametimeMenuPage extends JPanel {
//    public String username;
//    public int number;
//    JdbcConfig instance = JdbcConfig.getInstance();
//
//    public GametimeMenuPage(String username) {
//        this.username = username;
//
//        JLabel label[] = new JLabel[20];
//        setLayout(null);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 4; j++) {
//                label[i * 4 + j] = new JLabel(String.valueOf(i * 4 + j + 1));
//            }
//        }
//
//        String string;
//        string = instance.query("select guan from biao1 where name = '" + username + "';");
//        number = Integer.valueOf(string);
//
//        JButton back = new JButton();
//        back.setForeground(Color.black);
//        back.setIcon(new ImageIcon("图标/返回.jpg"));
//        back.setBounds(100, 820, 50, 50);
//        back.setBorderPainted(false);
//        add(back);
//
//        JButton question_icon = new JButton();
//        question_icon.setForeground(Color.black);
//        question_icon.setIcon(new ImageIcon("图标/问号.jpg"));
//        question_icon.setBounds(700, 50, 30, 30);
//        question_icon.setBorderPainted(false);
//        add(question_icon);
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 4; j++) {
//                int zhi = i * 4 + j;
//                if (zhi + 1 <= number) {
//                    if (zhi < 16)
//                        label[zhi].setForeground(Color.black);
//                    else
//                        label[zhi].setForeground(Color.red);
//                } else {
//                    label[zhi].setForeground(Color.lightGray);
//                }
//                label[zhi].setBounds(100 + j * 175, 100 + i * 150, 110, 50);
//                label[zhi].setFont(new Font("幼圆", 1, 50));
//                add(label[zhi]);
//            }
//        }
//        mouse(back, question_icon, label);
//    }
//
//    public void mouse(JButton back, JButton question_icon, JLabel label[]) {
//        back.addActionListener(e -> {
//            instance.update("delete from biao4 where number > 0;");
//            instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//            Main.user_choose();
//        });
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 4; j++) {
//                int zhi = i * 4 + j;
//                label[zhi].addMouseListener(new MouseAdapter() {
//                    public void mouseEntered(MouseEvent e) {             //移入
//                        if (zhi + 1 <= number)
//                            label[zhi].setForeground(Color.lightGray);
//                    }
//
//                    public void mouseExited(MouseEvent e) {              //移除
//                        if (zhi + 1 <= number) {
//                            if (zhi < 16)
//                                label[zhi].setForeground(Color.black);
//                            else
//                                label[zhi].setForeground(Color.red);
//                        }
//                    }
//
//                    public void mouseClicked(MouseEvent e) {             //单击
//                        if (e.getButton() == MouseEvent.BUTTON1 && zhi + 1 <= number) {       //开始游戏
//                            Main.num = zhi + 1;
//                            Main.number();
//                        }
//                    }
//                });
//            }
//        }
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
//    public void paint(Graphics gr) {
//        Graphics2D g = (Graphics2D) gr;
//        g.setBackground(Color.white);
//        g.clearRect(0, 0, getWidth(), getHeight());
//        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
//                0f);
//        g.setStroke(dash);
//        g.setColor(Color.gray);
//        g.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
//        super.paintComponents(g);
//    }
}
