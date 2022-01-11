package xu.game.okay.newCode.page.login;

import lombok.Data;
import xu.game.okay.newCode.constant.IconConstant;
import xu.game.okay.newCode.page.base.BaseJPanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@Data
public class LoginJPanel extends BaseJPanel {

    private static JLabel login_word = new JLabel("登录");

    public LoginJPanel() {

        login_word.setForeground(Color.gray);
        login_word.setFont(new java.awt.Font("幼圆", 1, 40));
        add(login_word);


//        JLabel username_word = new JLabel("用户名：");
//        username_word.setForeground(Color.gray);
//        username_word.setFont(new java.awt.Font("幼圆", 1, 25));
//        username_word.setBounds(35, 125, 250, 40);
//        p1.add(username_word);


//        JLabel password_word = new JLabel("密  码：");
//        password_word.setForeground(Color.gray);
//        password_word.setFont(new Font("幼圆", 1, 25));
//        password_word.setBounds(35, 175, 250, 40);
//        add(password_word);

//        cl.show();
//
        JTextField username = new JTextField(("用户名文本框"), 25);
        JPasswordField password = new JPasswordField("密码文本框", 25);
//        username.setBounds(140, 132, 175, 25);
        username.setFont(new Font("幼圆", 1, 25));
//        password.setBounds(140, 182, 175, 25);
        password.setFont(new Font("幼圆", 1, 25));
        password.setEchoChar('*');
//        add(username);
//        add(password, BorderLayout.CENTER);
//
        JLabel register_word = new JLabel("注册");
        register_word.setForeground(Color.gray);
        register_word.setFont(new Font("幼圆", 1, 20));
//        register_word.setBounds(300, 225, 50, 40);
//        add(register_word);
//
        JButton login_icon = new JButton();
        login_icon.setForeground(Color.black);
        login_icon.setIcon(new ImageIcon(IconConstant.LANDING));
//        login_icon.setBounds(140, 275, 100, 100);
        login_icon.setBorderPainted(false);
//        add(login_icon, BorderLayout.SOUTH);
//
//        JButton question_icon = new JButton();
//        question_icon.setForeground(Color.black);
//        question_icon.setIcon(new ImageIcon(IconConstant.QUESTION));
//        question_icon.setBounds(340, 35, 15, 15);
//        question_icon.setBorderPainted(false);
//        add(question_icon);
//        mouse(login_icon, username, password, register_word, question_icon);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            }
        });

    }

    @Override
    public void paint(Graphics g) {
//        Graphics2D gr = (Graphics2D) g;
        g.clearRect(0, 0, getWidth(), getHeight());
//        g.setBackground(Color.white);
//        gr.clearRect(0, 0, getWidth(), getHeight());
//        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
//                0f);
//        gr.setStroke(dash);
//        gr.setColor(Color.gray);
//        gr.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        repaint();
        super.paintComponents(g);
    }
}
