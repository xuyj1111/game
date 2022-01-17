package xu.game.okay.page.admin;

import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2020-03-07-17:25
 */
public class ManageUsersPage extends JPanel {
//    public int number;
//
//    public ManageUsersPage() {
//        JdbcConfig jdbcConfig = JdbcConfig.getInstance();
//        Connection connection = jdbcConfig.getConnection();
//        setLayout(null);
//        number = Integer.valueOf(jdbcConfig.query("select count(*) from biao1 where name != 'admin'"));
//        String[] strings = jdbcConfig.querys("select name from  biao1 where name != 'admin'");
//
//        JLabel[] users = new JLabel[number];
//        JLabel[] logout = new JLabel[number];
//        JLabel[] edit = new JLabel[number];
//        for (int i = 0; i < number; i++) {
//            users[i] = new JLabel((i + 1) + ": " + strings[i]);
//            users[i].setForeground(Color.gray);
//            users[i].setFont(new Font("幼圆", 1, 30));
//            if (i >= 9)
//                users[i].setBounds(35, 50 + i * 40, 200, 30);
//            else
//                users[i].setBounds(50, 50 + i * 40, 200, 30);
//            add(users[i]);
//
//            logout[i] = new JLabel("注销");
//            logout[i].setForeground(Color.gray);
//            logout[i].setFont(new Font("宋体", 1, 30));
//            logout[i].setBounds(600, 50 + i * 40, 80, 30);
//            add(logout[i]);
//
//            edit[i] = new JLabel("编辑");
//            edit[i].setForeground(Color.gray);
//            edit[i].setFont(new Font("宋体", 1, 30));
//            edit[i].setBounds(680, 50 + i * 40, 80, 30);
//            add(edit[i]);
//        }
//
//        JButton out = new JButton();
//        out.setForeground(Color.black);
//        out.setIcon(new ImageIcon("图标/admin/退出.jfif"));
//        out.setBounds(620, 780, 100, 100);
//        out.setBorderPainted(false);
//        add(out);
//
//        mouse(users, logout, edit, out);
//    }

//    public void mouse(JLabel[] users, JLabel[] logout, JLabel[] edit, JButton out) {
//
//        for (int i = 0; i < number; i++) {
//            logout[i].addMouseListener(new MouseAdapter_admin_logout(logout, i, users[i].getText()));
//            edit[i].addMouseListener(new MouseAdapter_admin_edit(edit, i, users[i].getText()));
//        }
//
//        out.addActionListener(e -> Main.admin_choose());
//    }

}
