package xu.game.okay.oldCode.page.admin;

import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2020-03-07-19:31
 */
public class ManageUsersEditPage extends JPanel {
//    JdbcConfig instance = JdbcConfig.getInstance();
//    public String username;
//    public static ArrayList list = new ArrayList();
//
//    public ManageUsersEditPage(String username) {
//        this.username = username;
//        setLayout(null);
//
//        JLabel user_word = new JLabel("用户：" + username);
//        user_word.setForeground(Color.gray);
//        user_word.setFont(new java.awt.Font("幼圆", 1, 80));
//        user_word.setBounds(100, 100, 700, 80);
//        add(user_word);
//
//        JLabel username_word = new JLabel("用户名：");
//        username_word.setForeground(Color.gray);
//        username_word.setFont(new java.awt.Font("幼圆", 1, 50));
//        username_word.setBounds(100, 230, 250, 50);
//        add(username_word);
//
//        JTextField username_field = new JTextField();
//        username_field.setBounds(300, 230, 350, 50);
//        username_field.setFont(new Font("幼圆", 1, 50));
//        username_field.setBackground(new Color(128, 128, 128));
//        username_field.setBorder(new EmptyBorder(0, 0, 0, 0));
//        add(username_field);
//
//        JLabel password_word = new JLabel("密  码：");
//        password_word.setForeground(Color.gray);
//        password_word.setFont(new java.awt.Font("幼圆", 1, 50));
//        password_word.setBounds(100, 310, 250, 50);
//        add(password_word);
//
//        JTextField password_field = new JTextField();
//        password_field.setBounds(300, 310, 350, 50);
//        password_field.setFont(new Font("幼圆", 1, 50));
//        password_field.setBackground(new Color(128, 128, 128));
//        password_field.setBorder(new EmptyBorder(0, 0, 0, 0));
//        add(password_field);
//
//        JLabel schedule_word = new JLabel("闯关进度：第    关");
//        schedule_word.setForeground(Color.gray);
//        schedule_word.setFont(new java.awt.Font("幼圆", 1, 50));
//        schedule_word.setBounds(100, 390, 600, 50);
//        add(schedule_word);
//
//        JComboBox jComboBox = new JComboBox();
//        jComboBox.setFont(new java.awt.Font("幼圆", 1, 50));
//        jComboBox.setBackground(new Color(128, 128, 128));
//        for (int i = 1; i <= 20; i++) {
//            jComboBox.addItem(i);
//        }
//        jComboBox.setBounds(425, 390, 100, 50);
//        jComboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
//        add(jComboBox);
//
//        JLabel defined_word = new JLabel("自定义关卡：");
//        defined_word.setForeground(Color.gray);
//        defined_word.setFont(new java.awt.Font("幼圆", 1, 50));
//        defined_word.setBounds(100, 470, 350, 50);
//        add(defined_word);
//
//        JButton menu = new JButton();
//        menu.setForeground(Color.black);
//        menu.setIcon(new ImageIcon("图标/admin/菜单.jpg"));
//        menu.setBounds(400, 470, 50, 50);
//        menu.setBorderPainted(false);
//        add(menu);
//
//        JButton ok = new JButton();
//        ok.setBounds(220, 600, 100, 100);
//        ok.setIcon(new ImageIcon("图标/admin/确定.jfif"));
//        ok.setBorderPainted(false);
//        add(ok);
//
//        JButton nok = new JButton();
//        nok.setBounds(460, 600, 100, 100);
//        nok.setIcon(new ImageIcon("图标/admin/取消.jfif"));
//        nok.setBorderPainted(false);
//        add(nok);
//
//        username_field.setText(username);
//        password_field.setText(instance.query("select password from biao1 where name = " + "'" + username + "'"));
//        jComboBox.setSelectedItem(Integer.valueOf(instance.query("select guan from biao1 where name = " + "'" + username + "'")));
//
//        mouse(ok, nok, menu, username_field, password_field, jComboBox);
//    }
//
//    public void mouse(JButton ok, JButton nok, JButton menu, JTextField username_field, JTextField password_field, JComboBox jComboBox) {
//        ok.addActionListener(e -> {
//            String string = instance.query("select name from biao1 where name = '" + username_field.getText() + "';");
//            if (username_field.getText().equals(""))
//                JOptionPane.showMessageDialog(null, "用户名不准为空");
//            else if (password_field.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "密码不准为空");
//            } else if (username_field.getText().equals(string) && !username_field.getText().equals(username))
//                JOptionPane.showMessageDialog(null, "该用户已存在");
//            else {
//                String password = instance.query("select password from biao1 where name = '"
//                        + username + "'");
//                String guan = instance.query("select guan from biao1 where name = '"
//                        + username + "'");
//                if (list.size() > 0) {
//                    Iterator iterator = list.iterator();
//                    while (iterator.hasNext()) {
//                        instance.update("delete from biao3 where nguan = " + iterator.next()
//                                + " AND name = '" + username + "';");
//                    }
//                }
//                list.removeAll(list);
//                if (!username_field.getText().equals(username)) {
//                    instance.update("update biao1 set name = '" + username_field.getText() +
//                            "' where name = '" + username + "'");
//                    instance.update("update biao3 set name = '" + username_field.getText() +
//                            "' where name = '" + username + "'");
//                }
//                if (!password_field.getText().equals(password)) {
//                    instance.update("update biao1 set password = '" + password_field.getText() +
//                            "' where name = '" + username + "'");
//                }
//                if (!jComboBox.getSelectedItem().equals(guan)) {
//                    instance.update("update biao1 set guan = '" + jComboBox.getSelectedItem() +
//                            "' where name = '" + username + "'");
//                }
//                Main.admin_manageUsers();
//            }
//        });
//
//        nok.addActionListener(e -> Main.admin_manageUsers());
//
//        menu.addActionListener(e -> {
//            Main.username = username;
//            Main.admin_manageDefinedMenu();
//        });
//    }
//
//    public void paint(Graphics gr) {
//        Graphics2D g = (Graphics2D) gr;
//        g.setBackground(Color.black);
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
