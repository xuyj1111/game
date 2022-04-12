package xu.game.okay.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import xu.game.okay.dto.PointDTO;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeProperty;
import xu.game.okay.enums.ShapeType;
import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.user.defined.DefinedControls;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description: 绘图板
 * @Author: xuyujun
 * @Date: 2022/3/24
 */
@Slf4j
public class DrawBoardUtil {

    //点之间的间隔
    private static final int INTERVAL = 20;
    //点阵图居中的x轴偏移量
    private static final int CENTER_OFFSET_X = 50;
    //点阵图居中的y轴偏移量
    private static final int CENTER_OFFSET_Y = 25;
    //点的西北向为起点，到点中心的偏移量
    private static final int POINRT_OFFSET = 8;

    //在调用该类方法前，必须要赋值drawJPanel！！！
    public static BaseJPanel drawJPanel;
    //绘图板已构建的图形集
    public static List<ShapeDTO> shapeDTOS = new ArrayList<>();
    //绘图板已点击的点集
    private static List<PointDTO> pointDTOS = new ArrayList<>();
    //序号
    private static int number = 0;
    //点击的时间戳，用于判断双击
    private static long clickTime;

    /**
     * @Description: 初始化
     */
    public static void init() {
        if (Objects.isNull(drawJPanel)) {
            return;
        }
        stopDraw();
        drawJPanel.setDrawnShape(null);
        drawJPanel = null;
        shapeDTOS.clear();
    }

    /**
     * @Description: 公共工具方法，绘图逻辑
     */
    public static void logicForDraw(int index, JButton pointB) {
        if (Objects.isNull(drawJPanel)) {
            log.warn("drawJPanel can not be null...");
            return;
        }
        //插入绘图"已构建的图形"代码
        if (Objects.isNull(drawJPanel.getDrawnShape())) {
            drawJPanel.setDrawnShape(g -> {
                shapeDTOS.forEach(shapeDTO -> {
                    if (shapeDTO.getType() == ShapeType.LINE) {
                        drawLine(g, shapeDTO.getPoint());
                    } else if (shapeDTO.getType() == ShapeType.CIRCLE) {
                        drawCircle(g, shapeDTO);
                    } else if (shapeDTO.getType() == ShapeType.POLYGON){
                        drawPolygon(g, shapeDTO);
                    }
                });
                return null;
            });
        }
        //记录点击'点'
        pointDTOS.add(PointDTO.builder().number(number).x(index / 20).y(index % 20).pointB(pointB).build());
        number++;
        int size = pointDTOS.size();
        //校验点击的位置
        checkLocation();
        //获取上一次点击的'点'
        PointDTO lastPoint = size > 1 ? pointDTOS.get(size - 2) : null;
        //根据点击的次数，绘画图形
        switch (size) {
            case 1:
                break;
            case 2: {
                long now = System.currentTimeMillis();
                if (lastPoint.getPointB().equals(pointB) && now - clickTime <= 1000) {
                    addCircle();
                    return;
                } else if (lastPoint.getPointB().equals(pointB) && now - clickTime > 1000) {
                    stopDraw();
                    return;
                }
            }
            default: {
                boolean hasSamePoint = pointDTOS.stream().filter(pointDTO -> pointDTO.getPointB().equals(pointB)).count() > 1;
                if (hasSamePoint && pointDTOS.get(0).getPointB().equals(pointB)) {
                    if (size > 3) {
                        addPolygon();
                    } else {
                        addLine();
                    }
                    return;
                } else if (hasSamePoint && size == 3) {
                    addLine();
                    return;
                } else if (hasSamePoint) {
                    stopDraw();
                    return;
                } else {
                    //连线
                    drawJPanel.setDrawing(g -> {
                        drawLine(g, pointDTOS);
                        return null;
                    });
                    lastPoint.getPointB().setBorderPainted(!lastPoint.getPointB().isBorderPainted());
                }
            }
        }
        clickTime = System.currentTimeMillis();
        pointB.setBorderPainted(!pointB.isBorderPainted());
    }

    /**
     * @Description: 检查点击位置
     */
    private static boolean checkLocation() {
        return true;
    }

    /**
     * @Description: 画线
     */
    private static void drawLine(Graphics2D g, List<PointDTO> points) {
        g.setColor(Color.black);
        for (int i = 0; i < points.size() - 1; i++) {
            PointDTO startPoint = points.get(i);
            PointDTO endPoint = points.get(i + 1);
            g.drawLine(INTERVAL * startPoint.getX() + CENTER_OFFSET_X + POINRT_OFFSET, INTERVAL * startPoint.getY() + CENTER_OFFSET_Y + POINRT_OFFSET,
                    INTERVAL * endPoint.getX() + CENTER_OFFSET_X + POINRT_OFFSET, INTERVAL * endPoint.getY() + CENTER_OFFSET_Y + POINRT_OFFSET);
            drawJPanel.repaint();
        }
    }

    /**
     * @Description: 画圆
     */
    private static void drawCircle(Graphics2D g, ShapeDTO shapeDTO) {
        PointDTO point = shapeDTO.getPoint().get(0);
        Integer size = shapeDTO.getSize();
        g.setColor(Color.gray);
        g.fillOval(INTERVAL * point.getX() + CENTER_OFFSET_X + POINRT_OFFSET - size / 2, INTERVAL * point.getY() + CENTER_OFFSET_Y + POINRT_OFFSET - size / 2, shapeDTO.getSize(), shapeDTO.getSize());
//        g.drawOval(INTERVAL * point.getX() + CENTER_OFFSET_X + POINRT_OFFSET - size / 2, INTERVAL * point.getY() + CENTER_OFFSET_Y + POINRT_OFFSET - size / 2, shapeDTO.getSize(), shapeDTO.getSize());
        drawJPanel.repaint();
    }

    /**
     * @Description: 画多边形
     */
    private static void drawPolygon(Graphics2D g, ShapeDTO shapeDTO) {
        int[] arrX = shapeDTO.getPoint().stream().mapToInt(p -> INTERVAL * p.getX() + CENTER_OFFSET_X + POINRT_OFFSET).toArray();
        int[] arrY = shapeDTO.getPoint().stream().mapToInt(p -> INTERVAL * p.getY() + CENTER_OFFSET_Y + POINRT_OFFSET).toArray();
        g.setColor(Color.gray);
        g.fillPolygon(arrX, arrY, shapeDTO.getPoint().size());
//        g.drawPolygon(x, y, ji + 1);
        drawJPanel.repaint();
    }

    /**
     * @Description: 添加线
     */
    private static void addLine() {
        shapeDTOS.add(ShapeDTO.builder().type(ShapeType.LINE).point(Lists.newArrayList(pointDTOS)).build());
        stopDraw();
    }

    /**
     * @Description: 添加圆
     */
    private static void addCircle() {
        //size 为圆的直径，所以需要 *2
        shapeDTOS.add(ShapeDTO.builder().type(ShapeType.CIRCLE).property(ShapeProperty.ELIMINATION).size(INTERVAL * 2).point(Lists.newArrayList(pointDTOS)).build());
        stopDraw();
    }

    /**
     * @Description: 添加多边形
     */
    private static void addPolygon() {
        shapeDTOS.add(ShapeDTO.builder().type(ShapeType.POLYGON).property(ShapeProperty.ELIMINATION).point(Lists.newArrayList(pointDTOS)).build());
        stopDraw();
    }

    /**
     * @Description: 停止当前绘画的图形
     */
    public static void stopDraw() {
        DefinedControls.components.forEach(point -> point.setBorderPainted(false));
        drawJPanel.setDrawing(null);
        pointDTOS.clear();
        number = 0;
    }
}
