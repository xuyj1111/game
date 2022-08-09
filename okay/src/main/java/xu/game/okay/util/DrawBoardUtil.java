package xu.game.okay.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import xu.game.okay.dto.PointDTO;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.ShapeProperty;
import xu.game.okay.enums.ShapeType;
import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.defined.DefinedControls;
import xu.game.okay.page.defined.DefinedJPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.INTERVAL;
import static xu.game.okay.constant.PageConstant.shapeProList;
import static xu.game.okay.util.RayCastUtil.realX;
import static xu.game.okay.util.RayCastUtil.realY;

/**
 * @Description: 绘图板
 * @Author: xuyujun
 * @Date: 2022/3/24
 */
@Slf4j
public class DrawBoardUtil {

    /**
     * 绘图板已构建的图形集
     */
    public static List<ShapeDTO> shapeDTOS = new ArrayList<>();

    /**
     * 绘图板已点击的'点'集
     */
    private static List<PointDTO> pointDTOS = new ArrayList<>();

    /**
     * '点'的序号
     */
    private static int number = 0;

    /**
     * 点击的时间戳，用于判断双击
     */
    private static long clickTime;

    public static DefinedJPanel drawJPanel = BeanFactory.definedJPanel;

    /**
     * @Description: 初始化
     */
    public static void init() {
        stopDraw();
        drawJPanel.setDrawnShape(null);
        drawJPanel.number = null;
        shapeDTOS.clear();
    }

    /**
     * @Description: 绘图逻辑
     */
    public static void logicForDraw(int index, JButton pointB) {
        setDefinedJPDrawnShape(drawJPanel);
        PointDTO dto = new PointDTO();
        dto.setNumber(number);
        dto.setPointB(pointB);
        dto.setX(index / 20);
        dto.setY(index % 20);
        // 记录点击'点'
        pointDTOS.add(dto);
        number++;
        int size = pointDTOS.size();
        // 校验点击的位置
        checkLocation();
        // 获取上一次点击的'点'
        PointDTO lastPoint = size > 1 ? pointDTOS.get(size - 2) : null;
        // 根据点击的次数，绘画图形
        switch (size) {
            case 1:
                break;
            case 2: {
                long now = System.currentTimeMillis();
                // 两次点击同一个点
                if (lastPoint.getPointB().equals(pointB)) {
                    // 时间差 <= 1s，表示双击画画
                    if (now - clickTime <= 1000) {
                        addCircle();
                        return;
                    }
                    // 否则退出
                    stopDraw();
                    return;
                }
            }
            default: {
                // 当前点是否被点击过
                boolean hasSamePoint = pointDTOS.stream().filter(pointDTO -> pointDTO.getPointB().equals(pointB)).count() > 1;
                if (hasSamePoint) {
                    // 与首次点击相同
                    if (pointDTOS.get(0).getPointB().equals(pointB)) {
                        if (size > 3) {
                            addPolygon();
                        } else {
                            addLine();
                        }
                        return;
                    } else if (size == 3) {
                        addLine();
                        return;
                    }
                    // 与首次点击不同，且不是第三次点击，退出
                    stopDraw();
                    return;
                }
                // 连线
                drawJPanel.setDrawing(g -> {
                    drawLine(g, pointDTOS);
                    return null;
                });
                lastPoint.getPointB().setBorderPainted(!lastPoint.getPointB().isBorderPainted());
            }
        }
        clickTime = System.currentTimeMillis();
        pointB.setBorderPainted(!pointB.isBorderPainted());
    }

    /**
     * @Description: 插入绘图"已构建的图形"代码
     */
    public static void setDefinedJPDrawnShape(BaseJPanel jPanel) {
        if (Objects.isNull(jPanel.getDrawnShape())) {
            jPanel.setDrawnShape(g -> {
                shapeDTOS.forEach(shapeDTO -> {
                    if (shapeDTO.getType() == ShapeType.LINE) {
                        drawLine(g, shapeDTO.getPoints());
                    } else if (shapeDTO.getType() == ShapeType.CIRCLE) {
                        drawCircle(g, shapeDTO);
                    } else if (shapeDTO.getType() == ShapeType.POLYGON) {
                        drawPolygon(g, shapeDTO);
                    }
                });
                return null;
            });
        }
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
            g.drawLine(realX(startPoint.getX()), realY(startPoint.getY()), realX(endPoint.getX()), realY(endPoint.getY()));
            drawJPanel.repaint();
        }
    }

    /**
     * @Description: 画圆
     */
    private static void drawCircle(Graphics2D g, ShapeDTO shapeDTO) {
        PointDTO point = shapeDTO.getPoints().get(0);
        Integer size = shapeDTO.getSize();
        switch (shapeDTO.getProperty()) {
            case ELIMINATION:
                g.setColor(Color.gray);
                g.fillOval(realX(point.getX()) - size, realY(point.getY()) - size, size * 2, size * 2);
                break;
            case DOUBLE_ELIMINATION:
                g.setColor(Color.lightGray);
                g.fillOval(realX(point.getX()) - size, realY(point.getY()) - size, size * 2, size * 2);
                break;
            case OBSTACLE:
                g.setColor(Color.black);
                g.fillOval(realX(point.getX()) - size, realY(point.getY()) - size, size * 2, size * 2);
                break;
            case BLACK_HOLE:
                g.setColor(Color.black);
                g.drawOval(realX(point.getX()) - size, realY(point.getY()) - size, size * 2, size * 2);
                break;
            default:
                break;
        }
        if (shapeDTO.getIsSelected()) {
            g.setColor(Color.red);
            g.drawOval(realX(point.getX()) - size, realY(point.getY()) - size, size * 2, size * 2);
        }
        drawJPanel.repaint();
    }

    /**
     * @Description: 画多边形
     */
    private static void drawPolygon(Graphics2D g, ShapeDTO shapeDTO) {
        int[] arrX = shapeDTO.getPoints().stream().mapToInt(p -> realX(p.getX())).toArray();
        int[] arrY = shapeDTO.getPoints().stream().mapToInt(p -> realY(p.getY())).toArray();
        switch (shapeDTO.getProperty()) {
            case ELIMINATION:
                g.setColor(Color.gray);
                g.fillPolygon(arrX, arrY, shapeDTO.getPoints().size());
                break;
            case DOUBLE_ELIMINATION:
                g.setColor(Color.lightGray);
                g.fillPolygon(arrX, arrY, shapeDTO.getPoints().size());
                break;
            case OBSTACLE:
                g.setColor(Color.black);
                g.fillPolygon(arrX, arrY, shapeDTO.getPoints().size());
                break;
            case BLACK_HOLE:
                g.setColor(Color.black);
                g.drawPolygon(arrX, arrY, shapeDTO.getPoints().size());
                break;
            default:
                break;
        }
        if (shapeDTO.getIsSelected()) {
            g.setColor(Color.red);
            g.drawPolygon(arrX, arrY, shapeDTO.getPoints().size());
        }
        drawJPanel.repaint();
    }

    /**
     * @Description: 添加线
     */
    private static void addLine() {
        ShapeDTO dto = new ShapeDTO();
        dto.setType(ShapeType.LINE);
        dto.setPoints(Lists.newArrayList(pointDTOS));
        shapeDTOS.add(dto);
        stopDraw();
    }

    /**
     * @Description: 添加圆
     */
    private static void addCircle() {
        ShapeDTO dto = new ShapeDTO();
        dto.setType(ShapeType.CIRCLE);
        dto.setProperty(ShapeProperty.ELIMINATION);
        dto.setSize(INTERVAL);
        dto.setPoints(Lists.newArrayList(pointDTOS));
        shapeDTOS.add(dto);
        stopDraw();
    }

    /**
     * @Description: 添加多边形
     */
    private static void addPolygon() {
        ShapeDTO dto = new ShapeDTO();
        dto.setType(ShapeType.POLYGON);
        dto.setProperty(ShapeProperty.ELIMINATION);
        dto.setPoints(Lists.newArrayList(pointDTOS));
        shapeDTOS.add(dto);
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

    /**
     * @Description: 修改图形大小或属性
     */
    public static void changeSizeOrProperty(ShapeDTO inside, MouseEvent e) {
        if (Objects.isNull(inside)) {
            // 清除所有选中
            DrawBoardUtil.shapeDTOS.forEach(shapeDTO -> shapeDTO.setIsSelected(false));
        } else {
            if (e.getButton() == MouseEvent.BUTTON1) {
                // 调整圆形大小
                if (inside.getIsSelected() && inside.getType() == ShapeType.CIRCLE) {
                    inside.setSize(inside.getSize() % 60 + INTERVAL);
                }
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                int index = shapeProList.indexOf(inside.getProperty());
                index = (index + 1) % 4;
                inside.setProperty(shapeProList.get(index));
            }
            // 清除所有选中
            DrawBoardUtil.shapeDTOS.forEach(shapeDTO -> shapeDTO.setIsSelected(false));
            // 选中
            inside.setIsSelected(!inside.getIsSelected());
        }
    }
}
