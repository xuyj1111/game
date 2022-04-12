package xu.game.okay.page.admin.userMenu.listener;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description: 自定义关卡数字键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class NumberMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

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
        if (label.getForeground().equals(Color.white)) {
            label.setForeground(Color.lightGray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if (label.getForeground().equals(Color.lightGray)) {
            label.setForeground(Color.white);
        }
    }
}
