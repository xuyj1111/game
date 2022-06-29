package xu.game.okay.page.play;

import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.play.listener.PlayMouseListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

/**
 * @Description: 游戏界面（或预览）
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public class PlayJPanel extends BaseJPanel {

    /**
     * @Description: 上级界面
     */
    public PlayJPanelSource source;

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
    }
}
