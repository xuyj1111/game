package xu.game.okay.page.admin.menu;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MenuJPanel extends BaseJPanel {
    @Override
    public void addControls() {
        add(MenuControls.returm);
        MenuControls.components.forEach(c -> add(c));
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.BLACK);
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
    }
}
