package xu.game.okay.util;

import xu.game.okay.dto.PointDTO;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeType;

import java.awt.Point;
import java.util.List;

import static xu.game.okay.constant.PageConstant.*;

/**
 * @Description: 射线法的实现及应用
 * @Author: xuyujun
 * @Date: 2022/4/25
 */
public class RayCastUtil {

    public static int realX(int x) {
        return INTERVAL * x + CENTER_OFFSET_X + POINRT_OFFSET;
    }

    public static int realY(int y) {
        return INTERVAL * y + CENTER_OFFSET_Y + POINRT_OFFSET;
    }

    /**
     * @Description: 判断"点"是否在图形内，并返回所在图形（不在内部返回null）
     */
    public static ShapeDTO isInside(Point point) {
        for (ShapeDTO shapeDTO : DrawBoardUtil.shapeDTOS) {
            boolean flag = false;
            ShapeType type = shapeDTO.getType();
            switch (type) {
                case CIRCLE:
                    flag = isInsideCircle(point, shapeDTO);
                    break;
                case POLYGON:
                    flag = isInsidePolygon(point, shapeDTO);
                    break;
                default:
                    break;
            }
            if (flag) {
                return shapeDTO;
            }
        }
        return null;
    }

    /**
     * @Description: 判断"点"是否在圆形内
     */
    private static boolean isInsideCircle(Point point, ShapeDTO shapeDTO) {
        List<PointDTO> points = shapeDTO.getPoints();
        int px = point.x;
        int py = point.y;
        int x = realX(points.get(0).getX());
        int y = realY(points.get(0).getY());
        return Math.abs(x - px) < shapeDTO.getSize() && Math.abs(y - py) < shapeDTO.getSize();
    }

    /**
     * @Description: 判断"点"是否在多边形内
     */
    private static boolean isInsidePolygon(Point point, ShapeDTO shapeDTO) {
        List<PointDTO> points = shapeDTO.getPoints();
        int size = points.size();
        int px = point.x;
        int py = point.y;
        boolean flag = false;
        // 遍历图形的每根线
        for (int i = 0; i < size - 1; i++) {
            int x1 = realX(points.get(i).getX());
            int y1 = realY(points.get(i).getY());
            int x2 = realX(points.get(i + 1).getX());
            int y2 = realY(points.get(i + 1).getY());
            // 点与多边形顶点重合
            if ((x1 == px && y1 == py) || (x2 == px && y2 == py)) {
                return true;
            }
            if (y1 != y2) {
                // p点的 y坐标 在线段的 y坐标 之间
                if ((py >= y1 && py <= y2) || (py >= y2 && py <= y1)) {
                    // 计算出线段上 y坐标=pY 点的 x坐标
                    double x = x1 + (double) (py - y1) * (x2 - x1) / (y2 - y1);
                    // 点在多边形的边上
                    if (x == px) {
                        return true;
                    }
                /*
                 思路：以p点开始，做一条平行于x轴，向右无限延长的线
                 x 大于 pX，表示 p点 在线段的左侧，则 (x, pY)点 是 p延长线与线段的交点
                 x 小于 pX，表示 p点 在线段的右侧，此认定为无交点
                 */
                    if (x > px) {
                        // 处理延伸线穿过顶点的情况
                        if (x == x1 || x == x2) {
                            if ((y1 < y2 && py == y1) || (y1 > y2 && py == y2)) {
                                flag = !flag;
                            }
                        } else {
                            flag = !flag;
                        }
                    }
                }
            } else if (py == y1 && ((px >= x1 && px <= x2) || (px >= x2 && px <= x1))) {
                // 处理p点在平行于x轴的线段上
                return true;
            }
        }
        return flag;
    }
}
