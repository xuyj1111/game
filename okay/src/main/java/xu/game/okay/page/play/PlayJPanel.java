package xu.game.okay.page.play;

import lombok.Getter;
import lombok.Setter;
import org.quartz.SchedulerFactory;
import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.play.listener.PlayMouseListener;
import xu.game.okay.util.Function3;

import java.awt.*;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.MOUSE_OFFSET_X;
import static xu.game.okay.constant.PageConstant.MOUSE_OFFSET_Y;

/**
 * @Description: 游戏界面（或预览）
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public class PlayJPanel extends BaseJPanel {

    /**
     * 上级界面
     */
    public PlayJPanelSource source;

    /**
     * 定时器，自增坐标实现小球移动
     */
    public SchedulerFactory schedulerFactory;

    /**
     * 拖拽线
     */
    @Getter
    @Setter
    private Function3<Graphics2D, Point, Point> dragLine;

    /**
     * 起点（初始为拉伸线的起点，随着小球的反弹会改变）
     */
    @Getter
    @Setter
    private Point startPoint;

    /**
     * 终点（初始为拉伸线的终点，随着小球的反弹会改变）
     */
    @Getter
    @Setter
    private Point endPoint;

    /**
     * 小球移动
     */
    @Getter
    @Setter
    private Function3<Graphics2D, Double, Double> ballMove;

    /**
     * 小球x坐标
     */
    @Getter
    @Setter
    private Double ballX;

    /**
     * 小球y坐标
     */
    @Getter
    @Setter
    private Double ballY;

    /**
     * 坐标自增量
     */
    @Getter
    @Setter
    private Double moveX;
    @Getter
    @Setter
    private Double moveY;

    @Override
    public void addControls() {
        add(PlayControls.returm);
        add(PlayControls.menu);
        add(PlayControls.question);
    }

    @Override
    public void addMouse() {
        addMouseListener(new PlayMouseListener());
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
        // 已构建的图形
        if (Objects.nonNull(getDrawnShape())) {
            getDrawnShape().apply(g);
        }
        // 拉伸线
        if (Objects.nonNull(getDragLine())) {
            endPoint = MouseInfo.getPointerInfo().getLocation();
            if (Objects.isNull(this.startPoint)) {
                startPoint = new Point(endPoint.x - MOUSE_OFFSET_X, endPoint.y - MOUSE_OFFSET_Y);
            }
            endPoint.setLocation(endPoint.x - MOUSE_OFFSET_X, endPoint.y - MOUSE_OFFSET_Y);
            getDragLine().apply(g, startPoint, endPoint);
        }
        // 小球移动
        if (Objects.nonNull(getBallMove())) {
            if (Objects.isNull(moveX) && Objects.isNull(moveY)) {
                ballX = (double) startPoint.x;
                ballY = (double) startPoint.y;
                calculationIncr(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            }
            getBallMove().apply(g, ballX, ballY);
        }
    }

    /**
     * @Description: 计算坐标自增量
     */
    public void calculationIncr(int startX, int startY, int endX, int endY) {
        double dStartX = startX;
        double dStartY = startY;
        double dEndX = endX;
        double dEndY = endY;
        if (startX != endX && startY != endY) {
            moveX = (dEndX - dStartX) / Math.abs(dEndY - dStartY);
            if (Math.abs(moveX) > 1) {
                moveX = moveX > 1 ? 1.0 : -1.0;
            }
            moveY = (dEndY - dStartY) / Math.abs(dEndX - dStartX);
            if (Math.abs(moveY) > 1) {
                moveY = moveY > 1 ? 1.0 : -1.0;
            }
        } else {
            if (startX == endX && startY != endY) {
                moveX = 1.0;
                moveY = 0.0;
            } else if (startX != endX) {
                moveX = 0.0;
                moveY = 1.0;
            }
        }
    }
}
