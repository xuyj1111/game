package xu.game.okay.page.admin.userEdit;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;

public class UserEditJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        add(UserEditControls.title);
        add(UserEditControls.userName);
        add(UserEditControls.userNameF);
        add(UserEditControls.pwd);
        add(UserEditControls.pwdF);
        add(UserEditControls.progress);
        add(UserEditControls.box);
        add(UserEditControls.defined);
        add(UserEditControls.menu);
        add(UserEditControls.confirm);
        add(UserEditControls.cancel);
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.black);
        g.clearRect(0, 0, getWidth(), getHeight());
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
                0f);
        g.setStroke(dash);
        g.setColor(Color.gray);
        g.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        super.paintComponents(g);
    }
}
