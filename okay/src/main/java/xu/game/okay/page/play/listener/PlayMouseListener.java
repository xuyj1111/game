package xu.game.okay.page.play.listener;

import xu.game.okay.page.play.PlayControls;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.RayCastUtil;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.BALL_DIAMETER;
import static xu.game.okay.constant.PageConstant.LINE_LENGTH;

/**
 * @Description: 游戏界面键
 * 在窗口内点击，显示或隐藏功能键
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public class PlayMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            PlayControls.isVisible = !PlayControls.isVisible;
            PlayControls.returm.setVisible(PlayControls.isVisible);
            PlayControls.menu.setVisible(PlayControls.isVisible);
            PlayControls.question.setVisible(PlayControls.isVisible);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (PlayControls.isVisible) {
            PlayControls.isVisible = false;
            PlayControls.returm.setVisible(false);
            PlayControls.menu.setVisible(false);
            PlayControls.question.setVisible(false);
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            BeanFactory.playJPanel.setDragLine(this::drawline);
            BeanFactory.playJPanel.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            BeanFactory.playJPanel.setDragLine(null);
            BeanFactory.playJPanel.setStartPoint(null);
            // 延时是解决jpanel刷新页面时，会出现拉伸线未清理情况
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            BeanFactory.playJPanel.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * @Description: 拉伸线的实现
     */
    private void drawline(Graphics2D g, Point startPoint, Point mousePoint) {
        int startX = startPoint.x;
        int startY = startPoint.y;
        int mouseX = mousePoint.x;
        int mouseY = mousePoint.y;
        // 使用double，小球跟鼠标移动精度更高
        double distanceX = startX - mouseX;
        double distanceY = startY - mouseY;

        g.setColor(Color.BLACK);
        for (int i = 0; i <= LINE_LENGTH; i++) {
            int locationX = (int) (startX - (distanceX / 6) * i - 5);
            int locationY = (int) (startY - (distanceY / 6) * i - 5);
            if (isDisplayed(locationX, locationY, BALL_DIAMETER - i)) {
                g.fillOval(locationX, locationY, BALL_DIAMETER - i, BALL_DIAMETER - i);
            }
        }
        BeanFactory.playJPanel.repaint();
    }

    /**
     * @Description: 判断拉伸线的小球是否显示（不覆盖图形）
     */
    private boolean isDisplayed(int locationX, int locationY, int diameter) {
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX, locationY)))) {
            return false;
        }
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX + diameter, locationY)))) {
            return false;
        }
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX, locationY + diameter)))) {
            return false;
        }
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX + diameter, locationY + diameter)))) {
            return false;
        }
        return true;
    }
}
