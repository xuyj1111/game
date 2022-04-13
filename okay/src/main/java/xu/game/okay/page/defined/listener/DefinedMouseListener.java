package xu.game.okay.page.defined.listener;

import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description: 自定义关卡界面键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class DefinedMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        DrawBoardUtil.stopDraw();
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
