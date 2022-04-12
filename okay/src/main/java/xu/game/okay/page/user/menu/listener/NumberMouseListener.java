package xu.game.okay.page.user.menu.listener;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description: 用户关卡数字键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class NumberMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
//        MainClass.jPanel = BeanFactory.menuJPanel;
//        MainClass.jFrame.setContentPane(MainClass.jPanel);
//        MainClass.jFrame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if (label.getForeground().equals(Color.black)) {
            label.setForeground(Color.lightGray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if (label.getForeground().equals(Color.lightGray)) {
            label.setForeground(Color.black);
        }
    }
}
