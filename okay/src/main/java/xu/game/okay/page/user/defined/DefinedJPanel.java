package xu.game.okay.page.user.defined;

import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.user.defined.listener.DefinedMouseListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

public class DefinedJPanel extends BaseJPanel {

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
        //动态执行绘图程序
        if (!Objects.isNull(getDrawing())) {
            getDrawing().apply(g);
        }
        if (!Objects.isNull(getDrawnShape())) {
            getDrawnShape().apply(g);
        }
    }
}
