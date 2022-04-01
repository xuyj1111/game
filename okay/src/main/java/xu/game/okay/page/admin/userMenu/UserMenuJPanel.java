package xu.game.okay.page.admin.userMenu;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UserMenuJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        add(UserMenuControls.returm);
        UserMenuControls.components.forEach(c -> add(c));
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.BLACK);
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
    }
}
