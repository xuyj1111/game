package xu.game.okay.page.admin.menu;

import com.google.common.collect.Lists;
import xu.game.okay.constant.IconConstant;
import xu.game.okay.page.admin.menu.listener.NumberMouseListener;
import xu.game.okay.page.admin.menu.listener.ReturnActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

public class MenuControls {

    public static JButton returm = new JButton();
    public static List<JLabel> components = Lists.newArrayList();

    static {
        returm.setForeground(Color.black);
        returm.setIcon(new ImageIcon(IconConstant.ADMIN_RETURN));
        returm.setBounds(50, 425, 25, 25);
        returm.setBorderPainted(false);
        returm.addActionListener(new ReturnActionListener());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int zhi = i * 4 + j;
                JLabel number = new JLabel(String.valueOf(zhi + 1));
                number.setBounds(50 + j * 85, 50 + i * 75, 55, 25);
                number.setFont(new Font("幼圆", 1, 25));
                if (zhi < 12) {
                    number.setForeground(Color.white);
                } else {
                    number.setForeground(new Color(205, 38, 38));
                }
                number.addMouseListener(new NumberMouseListener());
                components.add(number);
            }
        }
    }
}
