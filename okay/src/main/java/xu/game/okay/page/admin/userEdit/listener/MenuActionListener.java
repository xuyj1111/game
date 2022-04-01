package xu.game.okay.page.admin.userEdit.listener;

import org.springframework.util.CollectionUtils;
import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.admin.userEdit.UserEditControls;
import xu.game.okay.page.admin.userMenu.UserMenuControls;

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
        List<Long> levelIds = null;
        List<Map<String, Object>> querys = BeanFactory.jdbc.querys("SELECT level_id FROM level WHERE user = '%s' and is_system = 0", UserEditControls.userNameF.getText());
        if (!CollectionUtils.isEmpty(querys)) {
            levelIds = querys.stream().map(q -> (Long) q.get("level_id")).collect(Collectors.toList());
        }
        if (!CollectionUtils.isEmpty(levelIds)) {
            for (JLabel number : UserMenuControls.components) {
                if (levelIds.contains(Long.valueOf(number.getText()))) {
                    number.setForeground(Color.white);
                } else {
                    number.setForeground(new Color(50, 50, 50));
                }
            }
        } else {
            UserMenuControls.components.forEach(number -> number.setForeground(new Color(50, 50, 50)));
        }
        MainClass.jPanel = BeanFactory.userMenuJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
