package xu.game.okay.page.user.choose;

import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.listener.QuestionActionListener;
import xu.game.okay.page.user.choose.listener.DefinedActionListener;
import xu.game.okay.page.user.choose.listener.QuitActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class ChooseControls {
    public JLabel welcome;
    public static JButton through = new JButton();
    public static JButton defined = new JButton();
    public static JButton quit = new JButton();
    public static JButton question = new JButton();

    static {
        through.setForeground(Color.black);
        through.setIcon(new ImageIcon(IconConstant.BREAK_THROUGH));
        through.setBounds(130, 100, 150, 150);
        through.setBorderPainted(false);

        defined.setForeground(Color.black);
        defined.setIcon(new ImageIcon(IconConstant.CUSTOMER_DEFINE));
        defined.setBounds(130, 250, 150, 150);
        defined.setBorderPainted(false);
        defined.addActionListener(new DefinedActionListener());

        quit.setForeground(Color.black);
        quit.setIcon(new ImageIcon(IconConstant.QUIT));
        quit.setBounds(310, 390, 50, 50);
        quit.setBorderPainted(false);
        quit.addActionListener(new QuitActionListener());

        question.setForeground(Color.black);
        question.setIcon(new ImageIcon(IconConstant.QUESTION));
        question.setBounds(355, 30, 15, 15);
        question.setBorderPainted(false);
        question.addActionListener(new QuestionActionListener());
    }

    public ChooseControls(String userName) {
        //让用户名显示位置尽量居中
        String space = "  ";
        if (userName != null && userName.length() < 5) {
            for (int i = 0; i < 5 - userName.length(); i++) {
                space = space.concat(" ");
            }
        }
        this.welcome = new JLabel("Welcome" + space + userName);
        welcome.setForeground(Color.gray);
        welcome.setFont(new java.awt.Font("幼圆", 1, 40));
        welcome.setBounds(30, 50, 350, 40);
    }
}
