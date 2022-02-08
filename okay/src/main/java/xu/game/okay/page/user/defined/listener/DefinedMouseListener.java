package xu.game.okay.page.user.defined.listener;

import xu.game.okay.page.user.defined.DefinedControls;

import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class DefinedMouseListener implements MouseListener {

    /**
     * @Description: 鼠标点击
     * 取消选中的点，让其失去聚焦（即边框）
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        List<JButton> points = DefinedControls.components;
        points.forEach(p -> p.setBorderPainted(false));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
