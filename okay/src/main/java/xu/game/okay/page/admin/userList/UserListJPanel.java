package xu.game.okay.page.admin.userList;

import xu.game.okay.factory.BeanFactory;
import xu.game.okay.jdbc.JdbcAction;
import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class UserListJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        JdbcAction jdbc = BeanFactory.jdbc;
        List<Map<String, Object>> querys = jdbc.querys("SELECT * FROM user");

        add()
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
