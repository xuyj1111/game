package xu.game.okay.page.login;

import xu.game.okay.constant.FileConstant;
import xu.game.okay.page.login.listener.LoginActionListener;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.login.listener.RegisterMouseListener;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class LoginControls {

    public static JLabel login = new JLabel("登录");
    public static JLabel userName = new JLabel("用户名：");
    public static JLabel passWord = new JLabel("密  码：");
    public static JTextField userNameF = new JTextField();
    public static JPasswordField passWordF = new JPasswordField();
    public static JLabel register = new JLabel("注册");
    public static JButton loginJ = new JButton();
    public static JButton question = new JButton();

    static {
        login.setBounds(50, 50, 250, 40);
        login.setForeground(Color.gray);
        login.setFont(new java.awt.Font("幼圆", 1, 40));

        userName.setForeground(Color.gray);
        userName.setFont(new java.awt.Font("幼圆", 1, 25));
        userName.setBounds(35, 125, 250, 40);

        passWord.setForeground(Color.gray);
        passWord.setFont(new Font("幼圆", 1, 25));
        passWord.setBounds(35, 175, 250, 40);

        userNameF.setBounds(140, 132, 175, 25);
        userNameF.setFont(new Font("幼圆", 1, 25));

        passWordF.setBounds(140, 182, 175, 25);
        passWordF.setFont(new Font("幼圆", 1, 25));
        passWordF.setEchoChar('*');

        register.setForeground(Color.gray);
        register.setFont(new Font("幼圆", 1, 20));
        register.setBounds(300, 225, 50, 40);
        register.addMouseListener(new RegisterMouseListener());

        loginJ.setContentAreaFilled(false);
        loginJ.setIcon(new ImageIcon(FileConstant.LANDING));
        loginJ.setBounds(140, 275, 100, 100);
        loginJ.setBorderPainted(false);
        loginJ.addActionListener(new LoginActionListener());

        question.setContentAreaFilled(false);
        question.setIcon(new ImageIcon(FileConstant.QUESTION));
        question.setBounds(340, 35, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());
    }
}
