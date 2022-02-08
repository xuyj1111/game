package xu.game.okay.page.user.defined;

import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.user.defined.listener.DefinedMouseListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DefinedJPanel extends BaseJPanel {

    public Boolean isDraw = false;
    public JButton previousButton;

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

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
    }
}
