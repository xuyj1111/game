package xu.game.okay.page.defined.listener;

import xu.game.okay.MainClass;
import xu.game.okay.enums.DefinedJPanelSource;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 返回键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DrawBoardUtil.init();
        if (BeanFactory.definedJPanel.source == DefinedJPanelSource.USER) {
            MainClass.jPanel = BeanFactory.userChooseJPanel;
        } else if (BeanFactory.definedJPanel.source == DefinedJPanelSource.ADMIN_SYSTEM) {
            MainClass.jPanel = BeanFactory.adminMenuJPanel;
        } else {
            MainClass.jPanel = BeanFactory.userMenuJPanel;
        }
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
