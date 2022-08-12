package xu.game.okay.page.defined.listener;

import org.springframework.util.CollectionUtils;
import xu.game.okay.enums.DefinedJPanelSource;
import xu.game.okay.page.user.menu.MenuControls;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.*;

/**
 * @Description: 用户关卡菜单键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class MenuActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DrawBoardUtil.init();
        if (definedJPanel.source == DefinedJPanelSource.USER) {
            setUserLevelColor();
            jFrame.setContentPane(menuJPanel);
        } else if (definedJPanel.source == DefinedJPanelSource.ADMIN_SYSTEM) {
            jFrame.setContentPane(adminMenuJPanel);
        } else {
            jFrame.setContentPane(userMenuJPanel);
        }
        jFrame.setVisible(true);
    }

    private void setUserLevelColor() {
        List<Long> levelIds = null;
        List<String> names = null;
        List<Map<String, Object>> querys = jdbc.querys("SELECT level_id, name FROM level WHERE user = '%s' and is_system = 0 ORDER BY id", userChooseJPanel.userName);
        if (!CollectionUtils.isEmpty(querys)) {
            levelIds = querys.stream().map(q -> (Long) q.get("level_id")).collect(Collectors.toList());
            names = querys.stream().map(q -> String.valueOf(q.get("name"))).collect(Collectors.toList());
        }
        if (!CollectionUtils.isEmpty(levelIds)) {
            for (JLabel number : MenuControls.components) {
                if (levelIds.contains(Long.valueOf(number.getText()))) {
                    number.setForeground(Color.black);
                    number.setToolTipText(names.get(Integer.parseInt(number.getText()) - 1));
                } else {
                    //与Color.lightGray区别一下
                    number.setForeground(new Color(192, 192, 193));
                }
            }
        } else {
            MenuControls.components.forEach(number -> number.setForeground(new Color(192, 192, 193)));
        }
    }
}
