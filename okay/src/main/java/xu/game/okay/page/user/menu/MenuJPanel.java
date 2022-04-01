package xu.game.okay.page.user.menu;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MenuJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        add(MenuControls.returm);
        add(MenuControls.question);
        MenuControls.components.forEach(c -> add(c));
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
    }
}
