package xu.game.okay.page.user.choose.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 退出键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class QuitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainClass.jPanel = BeanFactory.loginJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
