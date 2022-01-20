package xu.game.okay.page.admin.userEdit;

import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.admin.userEdit.listener.CancelActionListener;
import xu.game.okay.page.admin.userEdit.listener.ConfirmActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class UserEditControls {
    //记录原用户名
    public static String recordUserName;
    public static JLabel title = new JLabel("编辑用户");
    public static JLabel userName = new JLabel("用户名：");
    public static JTextField userNameF = new JTextField();
    public static JLabel pwd = new JLabel("密  码：");
    public static JTextField pwdF = new JTextField();
    public static JLabel progress = new JLabel("闯关进度：第        关");
    public static JComboBox box = new JComboBox();
    public static JLabel defined = new JLabel("自定义关卡：");
    public static JButton menu = new JButton();
    public static JButton confirm = new JButton();
    public static JButton cancel = new JButton();


    static {
        title.setForeground(Color.gray);
        title.setFont(new java.awt.Font("幼圆", 1, 40));
        title.setBounds(50, 50, 350, 40);

        userName.setForeground(Color.gray);
        userName.setFont(new java.awt.Font("幼圆", 1, 25));
        userName.setBounds(50, 115, 175, 25);

        userNameF.setBounds(150, 115, 175, 25);
        userNameF.setFont(new Font("幼圆", 1, 25));
        userNameF.setBackground(new Color(128, 128, 128));
        userNameF.setBorder(new EmptyBorder(0, 0, 0, 0));

        pwd.setForeground(Color.gray);
        pwd.setFont(new java.awt.Font("幼圆", 1, 25));
        pwd.setBounds(50, 155, 175, 25);

        pwdF.setBounds(150, 155, 175, 25);
        pwdF.setFont(new Font("幼圆", 1, 25));
        pwdF.setBackground(new Color(128, 128, 128));
        pwdF.setBorder(new EmptyBorder(0, 0, 0, 0));

        progress.setForeground(Color.gray);
        progress.setFont(new java.awt.Font("幼圆", 1, 25));
        progress.setBounds(50, 195, 300, 25);

        box.setFont(new java.awt.Font("幼圆", 1, 10));
        box.setBackground(new Color(128, 128, 128));
        for (int i = 1; i <= 20; i++) {
            box.addItem(i);
        }
        box.setBounds(198, 195, 70, 30);
        box.setBorder(new EmptyBorder(0, 0, 0, 0));

        defined.setForeground(Color.gray);
        defined.setFont(new java.awt.Font("幼圆", 1, 25));
        defined.setBounds(50, 235, 175, 25);

        menu.setForeground(Color.black);
        menu.setIcon(new ImageIcon(IconConstant.ADMIN_MENU));
        menu.setBounds(200, 235, 25, 25);
        menu.setBorderPainted(false);

        confirm.setBounds(110, 300, 50, 50);
        confirm.setIcon(new ImageIcon(IconConstant.ADMIN_CONFIRM));
        confirm.setBorderPainted(false);
        confirm.addActionListener(new ConfirmActionListener());

        cancel.setBounds(230, 300, 50, 50);
        cancel.setIcon(new ImageIcon(IconConstant.ADMIN_CANCEL));
        cancel.setBorderPainted(false);
        cancel.addActionListener(new CancelActionListener());
    }
}
