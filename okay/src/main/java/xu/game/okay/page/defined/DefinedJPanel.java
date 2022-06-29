package xu.game.okay.page.defined;

import xu.game.okay.enums.DefinedJPanelSource;
import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.defined.listener.DefinedMouseListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

/**
 * @Description: 自定义关卡界面
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class DefinedJPanel extends BaseJPanel {

    /**
     * @Description: 上级界面
     */
    public DefinedJPanelSource source;

    /**
     * @Description: 当前页面的关卡序号
     */
    public String number;

    @Override
    public void addControls() {
        add(DefinedControls.returm);
        add(DefinedControls.delete);
        add(DefinedControls.confirm);
        add(DefinedControls.start);
        add(DefinedControls.menu);
        add(DefinedControls.question);
        DefinedControls.components.forEach(c -> add(c));
    }

    @Override
    public void addMouse() {
        addMouseListener(new DefinedMouseListener());
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
        // 动态执行绘图程序
        if (!Objects.isNull(getDrawing())) {
            getDrawing().apply(g);
        }
        if (!Objects.isNull(getDrawnShape())) {
            getDrawnShape().apply(g);
        }
    }
}
