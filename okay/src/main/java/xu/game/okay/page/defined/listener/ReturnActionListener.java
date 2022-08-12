package xu.game.okay.page.defined.listener;

import xu.game.okay.enums.DefinedJPanelSource;
import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.adminMenuJPanel;
import static xu.game.okay.util.BeanFactory.definedJPanel;
import static xu.game.okay.util.BeanFactory.userChooseJPanel;
import static xu.game.okay.util.BeanFactory.userMenuJPanel;

/**
 * @Description: 返回键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DrawBoardUtil.init();
        if (definedJPanel.source == DefinedJPanelSource.USER) {
            jFrame.setContentPane(userChooseJPanel);
        } else if (definedJPanel.source == DefinedJPanelSource.ADMIN_SYSTEM) {
            jFrame.setContentPane(adminMenuJPanel);
        } else {
            jFrame.setContentPane(userMenuJPanel);
        }
        jFrame.setVisible(true);
    }
}
