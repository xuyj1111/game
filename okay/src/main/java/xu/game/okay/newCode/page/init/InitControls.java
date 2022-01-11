package xu.game.okay.newCode.page.init;

import xu.game.okay.newCode.constant.IconConstant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class InitControls {

    public static Image img = new ImageIcon(IconConstant.INIT).getImage();
    public static JLabel lets = new JLabel("Let‘s");
    public static JLabel start = new JLabel("start...");

    static {
        lets.setBounds(150, 60, 250, 40);
        lets.setForeground(Color.black);
        lets.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 25));

        start.setBounds(250, 60, 250, 40);
        start.setForeground(Color.black);
        start.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 25));
    }

}
