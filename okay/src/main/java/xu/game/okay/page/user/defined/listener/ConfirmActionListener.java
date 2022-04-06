package xu.game.okay.page.user.defined.listener;

import org.springframework.util.CollectionUtils;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;
import xu.tools.json.JsonMapper;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Objects;

public class ConfirmActionListener implements ActionListener {
    private static long LIMIT_NUM = 20L;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (DrawBoardUtil.shapeDTOS.size() == 0) {
            return;
        }
        long count = 0L;
        Map<String, Object> query = BeanFactory.jdbc.query("select count(1) from level where user = '%s' and is_system = 0", BeanFactory.userChooseJPanel.userName);
        if (!CollectionUtils.isEmpty(query)) {
            count = (long) query.get("count(1)");
        }
        if (count == LIMIT_NUM) {
            JOptionPane.showMessageDialog(null, "关数已满，不可新增");
            return;
        }

        String name = JOptionPane.showInputDialog(null, "请输入关卡名");
        if (Objects.isNull(name)) {
            return;
        }
        String json = JsonMapper.writeValueAsString(DrawBoardUtil.shapeDTOS);
        BeanFactory.jdbc.update("insert into level(level_id, name, map, user, is_system) values(" +
                "IFNULL((select max(l.level_id) + 1 from level l where l.user = '%s' and l.is_system = 0), 1), " +
                "'%s', '%s', '%s', 0) ",
                BeanFactory.userChooseJPanel.userName,
                name, json,
                BeanFactory.userChooseJPanel.userName);
        DrawBoardUtil.init();
    }
}
