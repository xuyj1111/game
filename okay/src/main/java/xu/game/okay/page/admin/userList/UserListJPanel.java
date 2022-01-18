package xu.game.okay.page.admin.userList;

import xu.game.okay.entity.User;
import xu.game.okay.factory.BeanFactory;
import xu.game.okay.jdbc.JdbcAction;
import xu.game.okay.page.base.BaseJPanel;
import xu.tools.json.JsonMapper;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class UserListJPanel extends BaseJPanel {

    public UserListControls userListControls;

    /**
     * @Description: 该界面会变化，每次变化执行一次该addControls方法
     */
    @Override
    public void addControls() {
        removeAll();
        JdbcAction jdbc = BeanFactory.jdbc;
        java.util.List<Map<String, Object>> querys = jdbc.querys("SELECT * FROM user");
        List<User> users = JsonMapper.parseList(JsonMapper.writeValueAsString(querys), User.class);

        userListControls = new UserListControls(users);
        add(UserListControls.quit);
        userListControls.userJLabels.forEach(userJLabel -> {
            add(userJLabel.getUser());
            add(userJLabel.getLogout());
            add(userJLabel.getEdit());
        });
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
