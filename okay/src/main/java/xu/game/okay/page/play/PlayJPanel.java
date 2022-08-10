package xu.game.okay.page.play;

import lombok.Getter;
import lombok.Setter;
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
     * 拖拽线
     */
    @Getter
    @Setter
    private Function3<Graphics2D, Point, Point> dragLine;

    /**
     * 拖拽线的起点
     */
    @Getter
    @Setter
    private Point startPoint;

    @Getter
    @Setter
    private Point endPoint;

    @Getter
    @Setter
    private Function3<Graphics2D, Point, Point> ballMove;

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
        // 动态执行绘图程序
        if (!Objects.isNull(getDrawnShape())) {
            getDrawnShape().apply(g);
        }
        if (!Objects.isNull(getDragLine())) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            if (Objects.isNull(this.startPoint)) {
                this.startPoint = new Point(point.x - MOUSE_OFFSET_X, point.y - MOUSE_OFFSET_Y);
            }
            point.setLocation(point.x - MOUSE_OFFSET_X, point.y - MOUSE_OFFSET_Y);
            getDragLine().apply(g, this.startPoint, point);
        }
    }
}
