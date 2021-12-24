package xu.game.okay.oldCode.page.login;


import xu.game.okay.newCode.jdbc.JdbcConfig;
import xu.game.okay.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-06-22:07
 */
public class RegisterPage extends JPanel {
    JdbcConfig instance = JdbcConfig.getInstance();
    public RegisterPage() {
        setBounds(0, 0, getWidth(), getHeight());
        setLayout(null);

        JLabel register_word = new JLabel("注册");
        register_word.setForeground(Color.gray);
        register_word.setFont(new java.awt.Font("幼圆", 1, 80));
        register_word.setBounds(100, 100, 500, 80);
        add(register_word);

        JLabel username_word = new JLabel("用户名：");
        username_word.setForeground(Color.gray);
        username_word.setFont(new java.awt.Font("幼圆", 1, 50));
        username_word.setBounds(70, 250, 500, 80);
        add(username_word);

        JLabel password_word = new JLabel("密  码：");
        password_word.setForeground(Color.gray);
        password_word.setFont(new Font("幼圆", 1, 50));
        password_word.setBounds(70, 350, 500, 80);
        add(password_word);

        JLabel password_second_word = new JLabel("再次输入:");
        password_second_word.setForeground(Color.gray);
        password_second_word.setFont(new Font("幼圆", 1, 50));
        password_second_word.setBounds(50, 450, 500, 80);
        add(password_second_word);

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JPasswordField password_second = new JPasswordField();
        username.setBounds(300, 265, 350, 50);
        username.setFont(new Font("幼圆", 1, 50));
        password.setBounds(300, 365, 350, 50);
        password.setFont(new Font("幼圆", 1, 50));
        password.setEchoChar('*');
        password_second.setBounds(300, 465, 350, 50);
        password_second.setFont(new Font("幼圆", 1, 50));
        password_second.setEchoChar('*');
        add(username);
        add(password);
        add(password_second);

        JButton ok = new JButton();
        ok.setBounds(220, 600, 100, 100);
        ok.setIcon(new ImageIcon("图标/确定.jfif"));
        ok.setBorderPainted(false);
        add(ok);

        JButton nok = new JButton();
        nok.setBounds(460, 600, 100, 100);
        nok.setIcon(new ImageIcon("图标/取消.jfif"));
        nok.setBorderPainted(false);
        add(nok);

        JButton question_icon = new JButton();
        question_icon.setForeground(Color.black);
        question_icon.setIcon(new ImageIcon("图标/问号.jpg"));
        question_icon.setBounds(680, 70, 30, 30);
        question_icon.setBorderPainted(false);
        add(question_icon);

        mouse(username, password, password_second, ok, nok, question_icon);
    }

    public void mouse(JTextField username, JPasswordField password, JPasswordField password_second,
                      JButton ok, JButton nok, JButton question_icon) {
        ok.addActionListener(e -> {
            String string;
            if (username.getText().equals(""))
                JOptionPane.showMessageDialog(null, "请输入用户名");
            else if (password.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入密码");
            } else if (password_second.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入密码");
            } else {
                string = instance.query("select name from biao1 where name = '" + username.getText() + "';");
                if (username.getText().equals(string))
                    JOptionPane.showMessageDialog(null, "该用户已存在");
                else {
                    if (password.getText().equals(password_second.getText())) {              //返回login_panel
                        int number = Integer.valueOf(instance.query("select count(*) from biao1 where name != 'admin'"));
                        if (number == 18)
                            JOptionPane.showMessageDialog(null, "用户已满，不能注册 ");
                        else {
                            instance.update("INSERT INTO biao1 VALUES ('" + username.getText() + "','" +
                                    password.getText() + "',1);");
                            Main.login();
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "两次密码不一致 ");
                }
            }
        });
        nok.addActionListener(e -> Main.login());

        question_icon.addActionListener(e -> {
            File file = new File("图标/说明.txt");
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
                0f);
        g.setStroke(dash);
        g.setColor(Color.gray);
        g.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        super.paintComponents(g);
    }
}
