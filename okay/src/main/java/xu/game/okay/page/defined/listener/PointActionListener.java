package xu.game.okay.page.defined.listener;

import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeType;
import xu.game.okay.page.defined.DefinedControls;
import xu.game.okay.util.DrawBoardUtil;
import xu.game.okay.util.RayCastUtil;

import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.INTERVAL;

/**
 * @Description: `点`键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class PointActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        List<ShapeDTO> shapeDTOS = DrawBoardUtil.shapeDTOS;
        JButton pointB = (JButton) e.getSource();
        int x = getIndex(pointB) / 20;
        int y = getIndex(pointB) % 20;
        Point point = new Point(RayCastUtil.realX(x), RayCastUtil.realY(y));
        // 选中图形（另一处在DefinedMouseListener）
        ShapeDTO inside = RayCastUtil.isInside(point);
        if (Objects.isNull(inside)) {
            // 清除所有选中
            shapeDTOS.forEach(shapeDTO -> shapeDTO.setIsSelected(false));
            DrawBoardUtil.logicForDraw(getIndex(pointB), pointB);
        } else {
            // 调整圆形大小
            if (inside.getIsSelected() && inside.getType() == ShapeType.CIRCLE) {
                inside.setSize(inside.getSize() % 60 + INTERVAL);
            }
            // 清除所有选中
            shapeDTOS.forEach(shapeDTO -> shapeDTO.setIsSelected(false));
            // 选中
            inside.setIsSelected(!inside.getIsSelected());
        }
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
}
