package xu.game.okay.page.user.choose.listener;

import xu.game.okay.enums.DefinedJPanelSource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.definedJPanel;

/**
 * @Description: 自定义模式键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class DefinedActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        definedJPanel.source = DefinedJPanelSource.USER;
        jFrame.setContentPane(definedJPanel);
        jFrame.setVisible(true);
    }
}
