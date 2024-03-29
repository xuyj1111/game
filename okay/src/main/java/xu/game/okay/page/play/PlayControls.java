package xu.game.okay.page.play;

import xu.game.okay.constant.FileConstant;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.play.listener.MenuActionListener;
import xu.game.okay.page.play.listener.ReturnActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PlayControls {

    public static boolean isVisible = false;
    public static JButton returm = new JButton();
    public static JButton menu = new JButton();
    public static JButton question = new JButton();

    static {
        returm.setVisible(false);
        returm.setContentAreaFilled(false);
        returm.setIcon(new ImageIcon(FileConstant.RETURN));
        returm.setBounds(80, 425, 25, 25);
        returm.setBorderPainted(false);
        returm.addActionListener(new ReturnActionListener());

        menu.setVisible(false);
        menu.setContentAreaFilled(false);
        menu.setIcon(new ImageIcon(FileConstant.MENU));
        menu.setBounds(280, 425, 25, 25);
        menu.setBorderPainted(false);
        menu.addActionListener(new MenuActionListener());

        question.setVisible(false);
        question.setContentAreaFilled(false);
        question.setIcon(new ImageIcon(FileConstant.QUESTION));
        question.setBounds(355, 30, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());
    }

    public static void setControlsIsVisible(boolean visible) {
        isVisible = visible;
        returm.setVisible(isVisible);
        menu.setVisible(isVisible);
        question.setVisible(isVisible);
    }
}
