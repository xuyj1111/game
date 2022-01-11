package xu.game.okay.newCode.page.init;

import xu.game.okay.newCode.constant.IconConstant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class InitControls {

    private static Image img = new ImageIcon(IconConstant.INIT).getImage();


    JLabel lets = new JLabel("Let‘s");
            lets.setBounds(150, 60, 250, 40);
            lets.setForeground(Color.black);
            lets.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 25));
}
