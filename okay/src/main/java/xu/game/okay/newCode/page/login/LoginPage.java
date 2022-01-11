package xu.game.okay.newCode.page.login;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @Description:
 * @Author: xuyujun
 * @Date: 2021/12/24
 */
public class LoginPage extends BasePage {

    public LoginPage() {
        setBaseJPanel(new LoginJPanel());
        setBaseMouse(new LoginMouse());
        getBaseJPanel().addMouseListener(getBaseMouse());
    }


    public void mouse(JButton login_icon, JTextField username, JPasswordField password,
                      JLabel register_word, JButton question_icon) {
//        login_icon.addActionListener(e -> {
//            String string;
//            if (username.getText().equals(""))
//                JOptionPane.showMessageDialog(null, "请输入用户名");
//            else if (password.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "请输入密码");
//            } else {
//                string = instance.query("select name from biao1 where name = '"
//                        + username.getText() + "';");
//                if (username.getText().equals(string)) {
//                    string = instance.query("select password from biao1 where password = '"
//                            + password.getText() + "';");
//                    if (password.getText().equals(string)) {              //进入系统
//                        if (username.getText().equals("admin")) {
//                            Main.admin = true;
//                            Main.admin_choose();
//                        } else {
//                            Main.username = username.getText();
//                            Main.user_choose();
//                        }
//                    } else
//                        JOptionPane.showMessageDialog(null, "密码错误");
//                } else
//                    JOptionPane.showMessageDialog(null, "不存在该用户");
//            }
//        });
//        register_word.addMouseListener(new MouseAdapter() {
//            public void mouseEntered(MouseEvent e) {             //移入
//                register_word.setForeground(Color.BLUE);
//            }
//
//            public void mouseExited(MouseEvent e) {              //移除
//                register_word.setForeground(Color.gray);
//            }
//
//            public void mouseClicked(MouseEvent e) {
//                Main.register();
//            }
//        });
//        question_icon.addActionListener(e -> {
//            File file = new File("图标/说明.txt");
//            try {
//                Desktop.getDesktop().open(file);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
    }
}
