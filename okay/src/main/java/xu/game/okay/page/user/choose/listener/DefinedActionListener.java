package xu.game.okay.page.user.choose.listener;

import xu.game.okay.MainClass;
import xu.game.okay.enums.DefinedJPanelSource;
import xu.game.okay.util.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 自定义模式键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class DefinedActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BeanFactory.definedJPanel.source = DefinedJPanelSource.USER;
        MainClass.jPanel = BeanFactory.definedJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
