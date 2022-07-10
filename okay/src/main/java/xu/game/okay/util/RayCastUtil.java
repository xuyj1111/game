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
    public static boolean isInside(Point mousePoint, ShapeDTO shapeDTO) {
        ShapeType type = shapeDTO.getType();
        switch (type) {
            case CIRCLE:
                return isInsideCircle(mousePoint, shapeDTO);
            case POLYGON:
                return isInsidePolygon(mousePoint, shapeDTO);
            default:
                return false;
        }
    }

    /**
     * @Description: 判断当前鼠标是否在圆形内
     */
    private static boolean isInsideCircle(Point mousePoint, ShapeDTO shapeDTO) {
        List<PointDTO> points = shapeDTO.getPoints();
        int size = points.size();
        double pX = mousePoint.getX();
        double pY = mousePoint.getY();
        // 遍历图形的每根线，pointOne 和 pointTwo 是一根线的两端
        for (int pointOne = 0, pointTwo = size - 1; pointOne < size; pointTwo = pointOne, pointOne++) {
            int oneX = realX(points.get(pointOne).getX());
            int oneY = realY(points.get(pointOne).getY());
            int twoX = realX(points.get(pointTwo).getX());
            int twoY = realY(points.get(pointTwo).getY());
//            // 点与多边形顶点重合
            if ((oneX == pX && oneY == pY) || (twoX == pX && twoY == pY)) {
                return true;
            }



            
        }
        return false;
    }

    /**
     * @Description: 判断当前鼠标是否在多边形内
     */
    private static boolean isInsidePolygon(Point mousePoint, ShapeDTO shapeDTO) {


        return false;
    }

    public static int realX(int x) {
        return INTERVAL * x + CENTER_OFFSET_X + POINRT_OFFSET;
    }

    public static int realY(int y) {
        return INTERVAL * y + CENTER_OFFSET_Y + POINRT_OFFSET;
    }
}
