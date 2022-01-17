package xu.game.okay.page.register;

import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.register.listener.CancelActionListener;
import xu.game.okay.page.register.listener.ConfirmActionListener;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class RegisterControls {

    public static JLabel register = new JLabel("注册");
    public static JLabel userName = new JLabel("用户名：");
    public static JLabel passWord = new JLabel("密  码：");
    public static JLabel passWord2 = new JLabel("再次输入:");
    public static JTextField usernameF = new JTextField();
    public static JPasswordField passWordF = new JPasswordField();
    public static JPasswordField passWord2F = new JPasswordField();
    public static JButton confirm = new JButton();
    public static JButton cancel = new JButton();
    public static JButton question = new JButton();

    static {
        register.setForeground(Color.gray);
        register.setFont(new java.awt.Font("幼圆", 1, 40));
        register.setBounds(50, 50, 250, 40);

        userName.setForeground(Color.gray);
        userName.setFont(new java.awt.Font("幼圆", 1, 25));
        userName.setBounds(35, 125, 250, 40);

        passWord.setForeground(Color.gray);
        passWord.setFont(new Font("幼圆", 1, 25));
        passWord.setBounds(35, 175, 250, 40);

        passWord2.setForeground(Color.gray);
        passWord2.setFont(new Font("幼圆", 1, 25));
        passWord2.setBounds(25, 225, 250, 40);

        usernameF.setBounds(150, 135, 175, 25);
        usernameF.setFont(new Font("幼圆", 1, 25));

        passWordF.setBounds(150, 185, 175, 25);
        passWordF.setFont(new Font("幼圆", 1, 25));
        passWordF.setEchoChar('*');

        passWord2F.setBounds(150, 235, 175, 25);
        passWord2F.setFont(new Font("幼圆", 1, 25));
        passWord2F.setEchoChar('*');

        confirm.setBounds(110, 300, 50, 50);
        confirm.setIcon(new ImageIcon(IconConstant.CONFIRM));
        confirm.setBorderPainted(false);
        confirm.addActionListener(new ConfirmActionListener());

        cancel.setBounds(230, 300, 50, 50);
        cancel.setIcon(new ImageIcon(IconConstant.CANCEL));
        cancel.setBorderPainted(false);
        cancel.addActionListener(new CancelActionListener());

        question.setForeground(Color.black);
        question.setIcon(new ImageIcon(IconConstant.QUESTION));
        question.setBounds(340, 35, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());
    }
}
