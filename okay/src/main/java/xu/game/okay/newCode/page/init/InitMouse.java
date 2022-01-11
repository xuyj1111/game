package xu.game.okay.newCode.page.init;

import xu.game.okay.newCode.factory.BeanFactory;
import xu.game.okay.newCode.TestMain;
import xu.game.okay.newCode.page.base.BaseJPanel;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitMouse extends MouseAdapter {
    /**
     * @Description: 点击次数
     */
    private Integer check_num = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        BaseJPanel initJPanel = BeanFactory.initJPanel;
        if (check_num == 0) {
            JLabel lets = new JLabel("Let‘s");
            lets.setBounds(150, 60, 250, 40);
            lets.setForeground(Color.black);
            lets.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 25));
            initJPanel.add(lets);
            JLabel start = new JLabel("start...");
            start.setBounds(250, 60, 250, 40);
            start.setForeground(Color.black);
            start.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 25));
            initJPanel.add(start);
        } else {
            check_num = 0;
            TestMain.jPanel = BeanFactory.initJPanel;
            TestMain.jFrame.setContentPane(TestMain.jPanel);
            TestMain.jFrame.setVisible(true);
        }
        initJPanel.repaint();
        check_num++;
    }
}
