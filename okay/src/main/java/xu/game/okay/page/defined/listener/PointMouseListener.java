package xu.game.okay.page.defined.listener;

import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.page.defined.DefinedControls;
import xu.game.okay.util.ArithmeticUtil;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

/**
 * @Description: `点`键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class PointMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton pointB = (JButton) e.getSource();
        int x = getIndex(pointB) / 20;
        int y = getIndex(pointB) % 20;
        Point point = new Point(ArithmeticUtil.realX(x), ArithmeticUtil.realY(y));
        // 选中图形（另一处在DefinedMouseListener）
        ShapeDTO inside = ArithmeticUtil.isPointInside(point);
        if (Objects.isNull(inside)) {
            DrawBoardUtil.logicForDraw(getIndex(pointB), pointB);
        }
        DrawBoardUtil.changeSizeOrProperty(inside, e);
    }

    private int getIndex(JButton pointB) {
        int i = 0;
        for (JButton jButton : DefinedControls.components) {
            if (pointB.equals(jButton)) {
                break;
            }
            i++;
        }
        return i;
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
