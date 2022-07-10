package xu.game.okay.page.admin.choose;

import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.admin.choose.listener.ManageLevelActionListener;
import xu.game.okay.page.admin.choose.listener.ManageUserActionListener;
import xu.game.okay.page.admin.choose.listener.QuitActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ChooseControls {
    public static JLabel welcome = new JLabel("Welcome admin");
    public static JButton manageLevel = new JButton();
    public static JButton manageUser = new JButton();
    public static JButton quit = new JButton();

    static {
        welcome.setForeground(Color.gray);
        welcome.setFont(new Font("幼圆", 1, 40));
        welcome.setBounds(45, 50, 350, 40);

        manageLevel.setContentAreaFilled(false);
        manageLevel.setIcon(new ImageIcon(IconConstant.ADMIN_MANAGE_LEVEL));
        manageLevel.setBounds(125, 100, 150, 150);
        manageLevel.setBorderPainted(false);
        manageLevel.addActionListener(new ManageLevelActionListener());

        manageUser.setContentAreaFilled(false);
        manageUser.setIcon(new ImageIcon(IconConstant.ADMIN_MANAGE_USER));
        manageUser.setBounds(125, 250, 150, 150);
        manageUser.setBorderPainted(false);
        manageUser.addActionListener(new ManageUserActionListener());

        quit.setContentAreaFilled(false);
        quit.setIcon(new ImageIcon(IconConstant.ADMIN_QUIT));
        quit.setBounds(310, 390, 50, 50);
        quit.setBorderPainted(false);
        quit.addActionListener(new QuitActionListener());
    }
}
