package xu.game.okay.page.admin.userList;

import xu.game.okay.entity.User;
import xu.game.okay.page.base.BaseJPanel;
import xu.tools.json.JsonMapper;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static xu.game.okay.util.BeanFactory.jdbc;

/**
 * @Description: 用户列表界面
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
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
        g.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
        super.paintComponents(g);
    }
}
