package xu.game.okay.newCode.page;


import javax.swing.*;
import java.awt.*;

/**
* @Description:
* @Author: xuyujun
* @Date: 2021/12/24
*/
public class LoginPage extends BasePage {


//    public LoginPage() {
//        setBounds(0, 0, getWidth(), getHeight());
//        setLayout(null);
//
//
//        JLabel login_word = new JLabel("登录");
//        login_word.setBounds(100, 100, 500, 80);
//        login_word.setForeground(Color.gray);
//        login_word.setFont(new java.awt.Font("幼圆", 1, 80));
//        add(login_word);
//
//        JLabel username_word = new JLabel("用户名：");
//        username_word.setForeground(Color.gray);
//        username_word.setFont(new java.awt.Font("幼圆", 1, 50));
//        username_word.setBounds(70, 250, 500, 80);
//        add(username_word);
//
//        JLabel password_word = new JLabel("密  码：");
//        password_word.setForeground(Color.gray);
//        password_word.setFont(new Font("幼圆", 1, 50));
//        password_word.setBounds(70, 350, 500, 80);
//        add(password_word);
//
//        JTextField username = new JTextField();
//        JPasswordField password = new JPasswordField();
//        username.setBounds(280, 265, 350, 50);
//        username.setFont(new Font("幼圆", 1, 50));
//        password.setBounds(280, 365, 350, 50);
//        password.setFont(new Font("幼圆", 1, 50));
//        password.setEchoChar('*');
//        add(username);
//        add(password);
//
//        JLabel register_word = new JLabel("注册");
//        register_word.setForeground(Color.gray);
//        register_word.setFont(new Font("幼圆", 1, 40));
//        register_word.setBounds(600, 450, 100, 80);
//        add(register_word);
//
//        JButton login_icon = new JButton();
//        login_icon.setForeground(Color.black);
//        login_icon.setIcon(new ImageIcon("图标/登录.jfif"));
//        login_icon.setBounds(280, 550, 200, 200);
//        login_icon.setBorderPainted(false);
//        add(login_icon);
//
//        JButton question_icon = new JButton();
//        question_icon.setForeground(Color.black);
//        question_icon.setIcon(new ImageIcon("图标/问号.jpg"));
//        question_icon.setBounds(680, 70, 30, 30);
//        question_icon.setBorderPainted(false);
//        add(question_icon);
//        mouse(login_icon, username, password, register_word, question_icon);
//    }

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

    public void paint(Graphics gr) {
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
    }
}
