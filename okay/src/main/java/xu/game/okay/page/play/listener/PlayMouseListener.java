package xu.game.okay.page.play.listener;

import xu.game.okay.page.play.PlayControls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description: 游戏界面键
 * 在窗口内点击，显示或隐藏功能键
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public class PlayMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        PlayControls.isVisible = !PlayControls.isVisible;
        PlayControls.returm.setVisible(PlayControls.isVisible);
        PlayControls.menu.setVisible(PlayControls.isVisible);
        PlayControls.question.setVisible(PlayControls.isVisible);
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
