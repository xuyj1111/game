package xu.game.okay.page.admin.menu.listener;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description: 关卡数字键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class NumberMouseListener implements MouseListener {

    private Color foreground;

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
        foreground = label.getForeground();
        label.setForeground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setForeground(foreground);
    }
}
