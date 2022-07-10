package xu.game.okay.page.user.menu;

import com.google.common.collect.Lists;
import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.user.menu.listener.NumberMouseListener;
import xu.game.okay.page.user.menu.listener.ReturnActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

public class MenuControls {

    /**
     * 返回键
     */
    public static JButton returm = new JButton();

    /**
     * help键
     */
    public static JButton question = new JButton();

    /**
     * 关卡序号键
     */
    public static List<JLabel> components = Lists.newArrayList();

    static {

        returm.setContentAreaFilled(false);
        returm.setIcon(new ImageIcon(IconConstant.RETURN));
        returm.setBounds(50, 425, 25, 25);
        returm.setBorderPainted(false);
        returm.addActionListener(new ReturnActionListener());

        question.setContentAreaFilled(false);
        question.setIcon(new ImageIcon(IconConstant.QUESTION));
        question.setBounds(355, 30, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int zhi = i * 4 + j;
                JLabel number = new JLabel(String.valueOf(zhi + 1));
                number.setBounds(50 + j * 85, 50 + i * 75, 55, 25);
                number.setFont(new Font("幼圆", 1, 25));
                number.addMouseListener(new NumberMouseListener());
                components.add(number);
            }
        }
    }
}
