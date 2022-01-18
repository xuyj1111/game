package xu.game.okay.zoldCode.page.admin;

import xu.game.okay.jdbc.JdbcConfig;

import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2020-03-07-19:31
 */
public class ManageUsersEditPage extends JPanel {
    JdbcConfig instance = JdbcConfig.getInstance();
    public String username;
    public static ArrayList list = new ArrayList();

    public ManageUsersEditPage(String username) {
        this.username = username;
        setLayout(null);



//        username_field.setText(username);
//        password_field.setText(instance.query("select password from biao1 where name = " + "'" + username + "'"));
//        jComboBox.setSelectedItem(Integer.valueOf(instance.query("select guan from biao1 where name = " + "'" + username + "'")));
//
//        mouse(ok, nok, menu, username_field, password_field, jComboBox);
    }

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

}
