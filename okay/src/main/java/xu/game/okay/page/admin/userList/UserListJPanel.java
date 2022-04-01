package xu.game.okay.page.admin.userList;

import xu.game.okay.entity.User;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.jdbc.JdbcAction;
import xu.game.okay.page.base.BaseJPanel;
import xu.tools.json.JsonMapper;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class UserListJPanel extends BaseJPanel {

    public UserListControls userListControls;

    /**
     * @Description: 清空所有控件，并数据库中查询所有用户，重新添加控件
     */
    @Override
    public void addControls() {
        //清空
        removeAll();
        //数据库中查询所有用户
        JdbcAction jdbc = BeanFactory.jdbc;
        java.util.List<Map<String, Object>> querys = jdbc.querys("SELECT * FROM user WHERE name != 'admin'");
        List<User> users = JsonMapper.parseList(JsonMapper.writeValueAsString(querys), User.class);
        //添加控件
        userListControls = new UserListControls(users);
        add(UserListControls.quit);
        userListControls.userJLabels.forEach(userJLabel -> {
            add(userJLabel.getUser());
            add(userJLabel.getLogout());
            add(userJLabel.getEdit());
        });
    }

    @Override
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
