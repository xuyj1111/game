package xu.game.okay.util;

import xu.game.okay.dto.PointDTO;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeType;

import java.awt.Point;
import java.util.List;

/**
 * @Description: 射线法的实现及应用
 * @Author: xuyujun
 * @Date: 2022/4/25
 */
public class RayCastUtil {


    /**
     * 偏移量（随鼠标移动的小球有大小，需要在靠近的一定范围内就判定为在图形内部）
     */
    private static final int OFFSET_X = 50;
    private static final int OFFSET_Y = 50;

    /**
     * '点'之间的间隔
     */
    private static final int INTERVAL = 20;

    /**
     * 点阵图居中的x轴偏移量
     */
    private static final int CENTER_OFFSET_X = 50;

    /**
     * 点阵图居中的y轴偏移量
     */
    private static final int CENTER_OFFSET_Y = 25;

    /**
     * '点'的西北向为起点，到'点'中心的偏移量
     */
    private static final int POINRT_OFFSET = 8;

    /**
     * @Description: 判断当前鼠标是否在图形内
     */
    public static boolean isInside(Point point) {
        boolean flag = false;
        for (ShapeDTO shapeDTO : DrawBoardUtil.shapeDTOS) {
            ShapeType type = shapeDTO.getType();
            switch (type) {
                case CIRCLE:
                    flag = isInsideCircle(point, shapeDTO) | flag;
                    break;
                case POLYGON:
                    flag = isInsidePolygon(point, shapeDTO) | flag;
                    break;
                default:
                    break;
            }
        }
        return flag;
    }

    /**
     * @Description: 判断当前鼠标是否在圆形内
     */
    private static boolean isInsideCircle(Point point, ShapeDTO shapeDTO) {
        return false;
    }

    /**
     * @Description: 判断当前鼠标是否在多边形内
     */
    private static boolean isInsidePolygon(Point point, ShapeDTO shapeDTO) {
        List<PointDTO> points = shapeDTO.getPoints();
        int size = points.size();
        double px = point.getX();
        double py = point.getY();
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
            // p点的 y坐标 在线段的 y坐标 之间（不包括线段平行x轴）
            if ((py > y1 && py <= y2) || (py > y2 && py <= y1)) {
                // 计算出线段上 y坐标=pY 点的 x坐标（计算出的x坐标是double类型，但p点的坐标是整数，所以此处最大误差 0.99999...）
                int x = (int) (x1 + (py - y1) * (x2 - x1) / (y2 - y1));
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
                    flag = !flag;
                }
            }


            // p点的 x坐标 必须要在线段的 x坐标 之间（不包括线段平行x轴）
//            else if ((px > x1 && px <= x2) || (px > x2 && px <= x1)) {
//
//                // 计算出线段上 x坐标=pX 点的 y坐标（计算出的y坐标是double类型，但p点的坐标是整数，所以此处最大误差 0.99999...）
//                int y = (int) (y1 + (px - x1) * (y2 - y1) / (x2 - x1));
//                // 点在多边形的边上
//                if (y == py) {
//                    return true;
//                }
//                // 射线穿过多边形的边界
//                if (y > py) {
//                    flag = !flag;
//                }
//            }
        }
        return flag;
    }

    public static int realX(int x) {
        return INTERVAL * x + CENTER_OFFSET_X + POINRT_OFFSET;
    }

    public static int realY(int y) {
        return INTERVAL * y + CENTER_OFFSET_Y + POINRT_OFFSET;
    }
}
