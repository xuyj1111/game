package xu.game.okay.page.user.defined;

import com.google.common.collect.Lists;
import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.user.defined.listener.MenuActionListener;
import xu.game.okay.page.user.defined.listener.PointActionListener;
import xu.game.okay.page.user.defined.listener.ReturnActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.util.List;

public class DefinedControls {

    //点之间的间隔
    private static final int INTERVAL = 20;
    //点阵图居中的x轴偏移量
    private static final int CENTER_OFFSET_X = 50;
    //点阵图居中的y轴偏移量
    private static final int CENTER_OFFSET_Y = 25;

    public static JButton returm = new JButton();
    public static JButton delete = new JButton();
    public static JButton confirm = new JButton();
    public static JButton start = new JButton();
    public static JButton menu = new JButton();
    public static JButton question = new JButton();
    public static List<JButton> components = Lists.newArrayList();

    static {
        returm.setForeground(Color.black);
        returm.setIcon(new ImageIcon(IconConstant.RETURN));
        returm.setBounds(80, 425, 25, 25);
        returm.setBorderPainted(false);
        returm.addActionListener(new ReturnActionListener());

        delete.setForeground(Color.black);
        delete.setIcon(new ImageIcon(IconConstant.DELETE));
        delete.setBounds(130, 425, 25, 25);
        delete.setBorderPainted(false);

        confirm.setForeground(Color.black);
        confirm.setIcon(new ImageIcon(IconConstant.CONFIRM_SMALL));
        confirm.setBounds(180, 425, 25, 25);
        confirm.setBorderPainted(false);

        start.setForeground(Color.black);
        start.setIcon(new ImageIcon(IconConstant.START));
        start.setBounds(230, 425, 25, 25);
        start.setBorderPainted(false);

        menu.setForeground(Color.black);
        menu.setIcon(new ImageIcon(IconConstant.MENU));
        menu.setBounds(280, 425, 25, 25);
        menu.setBorderPainted(false);
        menu.addActionListener(new MenuActionListener());

        question.setForeground(Color.black);
        question.setIcon(new ImageIcon(IconConstant.QUESTION));
        question.setBounds(355, 30, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                JButton pointB = new JButton();
                pointB.setIcon(new ImageIcon(IconConstant.POINT));
                pointB.setBounds(INTERVAL * i + CENTER_OFFSET_X, INTERVAL * j + CENTER_OFFSET_Y, 15, 15);
                pointB.setBorderPainted(false);
                pointB.addActionListener(new PointActionListener());
                components.add(pointB);
            }
        }
    }
}
