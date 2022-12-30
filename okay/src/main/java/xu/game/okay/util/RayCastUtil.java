package xu.game.okay.util;

import com.google.common.collect.Lists;
import lombok.Builder;
import xu.game.okay.dto.PointDTO;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeType;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static xu.game.okay.constant.PageConstant.CENTER_OFFSET_X;
import static xu.game.okay.constant.PageConstant.CENTER_OFFSET_Y;
import static xu.game.okay.constant.PageConstant.INTERVAL;
import static xu.game.okay.constant.PageConstant.POINRT_OFFSET;

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
     * @Description: 判断拉伸线的小球是否在图形内，并返回所在图形（不在内部返回null）
     * 在 RayCastUtil.isInside 的基础上，以小球的左上、左下、右上、右下四点作为判断
     */
    public static ShapeDTO isBallInside(int locationX, int locationY, int diameter) {
        for (ShapeDTO shapeDTO : DrawBoardUtil.shapeDTOS) {
            boolean flag = false;
            ShapeType type = shapeDTO.getType();
            switch (type) {
                case CIRCLE:
                    flag = isBallInsideCircle(locationX, locationY, diameter, shapeDTO);
                    break;
                case POLYGON:
                    flag = isBallInsidePolygon(locationX, locationY, diameter, shapeDTO);
                    break;
                case LINE:
                    flag = isBallInsideLine(locationX, locationY, diameter, shapeDTO);
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
     * @Description: 判断"点"是否在图形内，并返回所在图形（不在内部返回null）
     * 不包含"线"的情况
     */
    public static ShapeDTO isPointInside(Point point) {
        for (ShapeDTO shapeDTO : DrawBoardUtil.shapeDTOS) {
            boolean flag = false;
            ShapeType type = shapeDTO.getType();
            switch (type) {
                case CIRCLE:
                    flag = isPointInsideCircle(point, shapeDTO);
                    break;
                case POLYGON:
                    flag = isPointInsidePolygon(point, shapeDTO);
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
     * @Description: 判断"小球"是否在圆形内
     * 左上、左下、右上、右下四点判断
     */
    private static boolean isBallInsideCircle(int locationX, int locationY, int diameter, ShapeDTO shapeDTO) {
        ArrayList<Point> points = Lists.newArrayList(
                new Point(locationX, locationY),
                new Point(locationX + diameter, locationY),
                new Point(locationX, locationY + diameter),
                new Point(locationX + diameter, locationY + diameter));
        for (Point point : points) {
            if (isPointInsideCircle(point, shapeDTO)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 判断"点"是否在圆形内
     */
    private static boolean isPointInsideCircle(Point point, ShapeDTO shapeDTO) {
        List<PointDTO> points = shapeDTO.getPoints();
        int px = point.x;
        int py = point.y;
        int x = realX(points.get(0).getX());
        int y = realY(points.get(0).getY());
        return Math.abs(x - px) < shapeDTO.getSize() && Math.abs(y - py) < shapeDTO.getSize();
    }

    /**
     * @Description: 判断"小球"是否在多边形内
     * 左上、左下、右上、右下四点判断
     */
    private static boolean isBallInsidePolygon(int locationX, int locationY, int diameter, ShapeDTO shapeDTO) {
        ArrayList<Point> points = Lists.newArrayList(
                new Point(locationX, locationY),
                new Point(locationX + diameter, locationY),
                new Point(locationX, locationY + diameter),
                new Point(locationX + diameter, locationY + diameter));
        for (Point point : points) {
            if (isPointInsidePolygon(point, shapeDTO)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 判断"点"是否在多边形内
     */
    private static boolean isPointInsidePolygon(Point point, ShapeDTO shapeDTO) {
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
                        // 处理延伸线穿过顶点的情况（no垂直线）
                        if (x1 != x2 && (x == x1 || x == x2)) {
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

    /**
     * @Description: 判断"小球"是否与线重合
     * 以小球的左上、左下、右上、右下四点，可以构建成一个矩形，因此可以看作"判断矩形是否与线段相交"
     * 分为两种情况：
     * 1. 线段的端点是否在矩形内，可以通过 isPointInsidePolygon 判断
     * 2. 线段的端点不在矩形内，则判断线段是否与矩形的两个对角线相交
     * 此方法重点实现第二种情况
     * 具体算法说明：https://blog.csdn.net/qq826309057/article/details/70942061
     */
    private static boolean isBallInsideLine(int locationX, int locationY, int diameter, ShapeDTO shapeDTO) {
        // 构建小球的矩形
        ShapeDTO ballShape = new ShapeDTO();
        ballShape.setPoints(Lists.newArrayList(
                new PointDTO(locationX, locationY),
                new PointDTO(locationX + diameter, locationY),
                new PointDTO(locationX, locationY + diameter),
                new PointDTO(locationX + diameter, locationY + diameter)));
        // 两根对角线
        Line diagonalL1 = Line.builder().x1(locationX).y1(locationY).x2(locationX + diameter).y2(locationY + diameter).build();
        Line diagonalL2 = Line.builder().x1(locationX + diameter).y1(locationY).x2(locationX).y2(locationY + diameter).build();
        // "线段"图形
        Line line = Line.builder()
                .x1(realX(shapeDTO.getPoints().get(0).getX()))
                .y1(realY(shapeDTO.getPoints().get(0).getY()))
                .x2(realX(shapeDTO.getPoints().get(1).getX()))
                .y2(realY(shapeDTO.getPoints().get(1).getY()))
                .build();
        // 情况一：判断线段的两端点是否在矩形内
        if (isPointInsidePolygon(new Point(line.x1, line.y1), ballShape) ||
                isPointInsidePolygon(new Point(line.x2, line.y2), ballShape)) {
            return true;
        }
        // 情况二：判断线段是否与两条对角线相交
        // 对角线1和线段判断
        //快速排斥实验
        if ((Math.max(line.x1, line.x2)) >= (Math.min(diagonalL1.x1, diagonalL1.x2)) &&
                (Math.max(line.y1, line.y2)) >= (Math.min(diagonalL1.y1, diagonalL1.y2)) &&
                (Math.max(diagonalL1.x1, diagonalL1.x2)) >= (Math.min(line.x1, line.x2)) &&
                (Math.max(diagonalL1.y1, diagonalL1.y2)) >= (Math.min(line.y1, line.y2))) {
            //跨立实验
            if ((((line.x1 - diagonalL1.x1) * (diagonalL1.y2 - diagonalL1.y1) - (line.y1 - diagonalL1.y1) * (diagonalL1.x2 - diagonalL1.x1)) *
                    ((line.x2 - diagonalL1.x1) * (diagonalL1.y2 - diagonalL1.y1) - (line.y2 - diagonalL1.y1) * (diagonalL1.x2 - diagonalL1.x1))) <= 0 &&
                    (((diagonalL1.x1 - line.x1) * (line.y2 - line.y1) - (diagonalL1.y1 - line.y1) * (line.x2 - line.x1)) *
                            ((diagonalL1.x2 - line.x1) * (line.y2 - line.y1) - (diagonalL1.y2 - line.y1) * (line.x2 - line.x1))) <= 0) {
                return true;
            }
        }
        // 对角线2和线段判断
        //快速排斥实验
        if ((Math.max(line.x1, line.x2)) >= (Math.min(diagonalL2.x1, diagonalL2.x2)) &&
                (Math.max(line.y1, line.y2)) >= (Math.min(diagonalL2.y1, diagonalL2.y2)) &&
                (Math.max(diagonalL2.x1, diagonalL2.x2)) >= (Math.min(line.x1, line.x2)) &&
                (Math.max(diagonalL2.y1, diagonalL2.y2)) >= (Math.min(line.y1, line.y2))) {
            //跨立实验
            if ((((line.x1 - diagonalL2.x1) * (diagonalL2.y2 - diagonalL2.y1) - (line.y1 - diagonalL2.y1) * (diagonalL2.x2 - diagonalL2.x1)) *
                    ((line.x2 - diagonalL2.x1) * (diagonalL2.y2 - diagonalL2.y1) - (line.y2 - diagonalL2.y1) * (diagonalL2.x2 - diagonalL2.x1))) <= 0 &&
                    (((diagonalL2.x1 - line.x1) * (line.y2 - line.y1) - (diagonalL2.y1 - line.y1) * (line.x2 - line.x1)) *
                            ((diagonalL2.x2 - line.x1) * (line.y2 - line.y1) - (diagonalL2.y2 - line.y1) * (line.x2 - line.x1))) <= 0) {
                return true;
            }
        }
        return false;
    }

    @Builder
    static class Line {
        int x1, y1;
        int x2, y2;
    }
}
