package xu.game.okay.page.user.defined.listener;

import org.springframework.util.CollectionUtils;
import xu.game.okay.MainClass;
import xu.game.okay.page.user.menu.MenuControls;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DrawBoardUtil.init();
        List<Long> levelIds = null;
        List<Map<String, Object>> querys = BeanFactory.jdbc.querys("SELECT level_id FROM level WHERE user = '%s' and is_system = 0", BeanFactory.userChooseJPanel.userName);
        if (!CollectionUtils.isEmpty(querys)) {
            levelIds = querys.stream().map(q -> (Long) q.get("level_id")).collect(Collectors.toList());
        }
        if (!CollectionUtils.isEmpty(levelIds)) {
            for (JLabel number : MenuControls.components) {
                if (levelIds.contains(Long.valueOf(number.getText()))) {
                    number.setForeground(Color.black);
                } else {
                    //区别一下Color.lightGray
                    number.setForeground(new Color(192,192,193));
                }
            }
        } else {
            MenuControls.components.forEach(number -> number.setForeground(new Color(192,192,193)));
        }
        MainClass.jPanel = BeanFactory.menuJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
