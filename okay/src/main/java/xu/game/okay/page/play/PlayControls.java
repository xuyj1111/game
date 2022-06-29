package xu.game.okay.page.play;

import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.play.listener.MenuActionListener;
import xu.game.okay.page.play.listener.ReturnActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class PlayControls {

    public static boolean isVisible = false;
    public static JButton returm = new JButton();
    public static JButton menu = new JButton();
    public static JButton question = new JButton();

    static {
        returm.setVisible(false);
        returm.setForeground(Color.black);
        returm.setIcon(new ImageIcon(IconConstant.RETURN));
        returm.setBounds(80, 425, 25, 25);
        returm.setBorderPainted(false);
        returm.addActionListener(new ReturnActionListener());

        menu.setVisible(false);
        menu.setForeground(Color.black);
        menu.setIcon(new ImageIcon(IconConstant.MENU));
        menu.setBounds(280, 425, 25, 25);
        menu.setBorderPainted(false);
        menu.addActionListener(new MenuActionListener());

        question.setVisible(false);
        question.setForeground(Color.black);
        question.setIcon(new ImageIcon(IconConstant.QUESTION));
        question.setBounds(355, 30, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());
    }
}
