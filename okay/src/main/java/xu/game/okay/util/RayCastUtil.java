package xu.game.okay.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import xu.game.okay.dto.PointDTO;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeType;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
     * @Description: 判断拉伸线的小球是否在图形内，并返回所在图形（不在内部返回null）
     * 在 RayCastUtil.isInside 的基础上，以小球的左上、左下、右上、右下四点作为判断
     */
    public static ShapeDTO isBallInside(int locationX, int locationY, int diameter) {
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


//        ArrayList<Point> points = Lists.newArrayList(
//                new Point(locationX, locationY),
//                new Point(locationX + diameter, locationY),
//                new Point(locationX, locationY + diameter),
//                new Point(locationX + diameter, locationY + diameter));
//        for (Point point : points) {
//            ShapeDTO shapeDTO = isPointInside(point);
//            if (Objects.nonNull(shapeDTO)) {
//                return shapeDTO;
//            }
//        }
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
     * 左上、左下、右上、右下四点判断
     */
    private static boolean isBallInsideLine(int locationX, int locationY, int diameter, ShapeDTO shapeDTO) {
        ArrayList<Point> leftOrFarList = Lists.newArrayList();

        int p1x = locationX, p1y = locationY;
        int p2x = locationX + diameter, p2y = locationY;
        int p3x = locationX, p3y = locationY + diameter;
        int p4x = locationX + diameter, p4y = locationY + diameter;

        ArrayList<Point> points = Lists.newArrayList(
                new Point(locationX, locationY),
                new Point(locationX + diameter, locationY),
                new Point(locationX, locationY + diameter),
                new Point(locationX + diameter, locationY + diameter));
        int x1 = realX(shapeDTO.getPoints().get(0).getX());
        int y1 = realY(shapeDTO.getPoints().get(0).getY());
        int x2 = realX(shapeDTO.getPoints().get(1).getX());
        int y2 = realY(shapeDTO.getPoints().get(1).getY());

        for (Point point : points) {
            int px = point.x;
            int py = point.y;
            // 点与多边形顶点重合
            if ((x1 == px && y1 == py) || (x2 == px && y2 == py)) {
                return true;
            }
        }

        if (y1 != y2) {
//            // p点的 y坐标 在线段的 y坐标 之间
//            if ((py >= y1 && py <= y2) || (py >= y2 && py <= y1)) {
//                // 计算出线段上 y坐标=pY 点的 x坐标
//                double x = x1 + (double) (py - y1) * (x2 - x1) / (y2 - y1);
//                // 点在多边形的边上
//                if (x == px) {
//                    return true;
//                }
//            }


            for (Point point : points) {
                int px = point.x;
                int py = point.y;
                // p点的 y坐标 在线段的 y坐标 之间
                if ((py >= y1 && py <= y2) || (py >= y2 && py <= y1)) {
                    // 计算出线段上 y坐标=pY 点的 x坐标
                    double x = x1 + (double) (py - y1) * (x2 - x1) / (y2 - y1);
                    // 点在多边形的边上
                    if (x == px) {
                        return true;
                    } else if (x > px) {
                        // p点在线的左边，放入list
                        leftOrFarList.add(point);
                    }
                } else if ((px >= x1 && px <= x2) || (px >= x2 && px <= x1)) {
                    // p点的 x坐标 在线段的 x坐标之间

                } else {
                    // p点的 x坐标 和 y坐标 远离线段
                    leftOrFarList.add(point);
                }
            }


        } else if (py == y1 && ((px >= x1 && px <= x2) || (px >= x2 && px <= x1))) {
            // 处理p点在平行于x轴的线段上
            return true;
        }
        return false;
    }
}
