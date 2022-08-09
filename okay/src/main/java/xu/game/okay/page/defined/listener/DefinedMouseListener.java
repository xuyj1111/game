package xu.game.okay.page.defined.listener;

import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeType;
import xu.game.okay.util.DrawBoardUtil;
import xu.game.okay.util.RayCastUtil;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.INTERVAL;
import static xu.game.okay.constant.PageConstant.MOUSE_OFFSET_X;
import static xu.game.okay.constant.PageConstant.MOUSE_OFFSET_Y;

/**
 * @Description: 自定义关卡界面键
 * 1. 在'点'之外的窗口内区域点击，清除当前绘画
 * 2. 选中已构建图形
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class DefinedMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        DrawBoardUtil.stopDraw();
        List<ShapeDTO> shapeDTOS = DrawBoardUtil.shapeDTOS;
        // 获取当前鼠标位置
        Point point = MouseInfo.getPointerInfo().getLocation();
        point.setLocation(point.x - MOUSE_OFFSET_X, point.y - MOUSE_OFFSET_Y);
        // 选中图形（另一处在PointActionListener）
        ShapeDTO inside = RayCastUtil.isInside(point);
        if (Objects.isNull(inside)) {
            // 清除所有选中
            shapeDTOS.forEach(shapeDTO -> shapeDTO.setIsSelected(false));
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
