package xu.game.okay.page.admin.choose.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.loginJPanel;

/**
 * @Description: 退出键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class QuitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.setContentPane(loginJPanel);
        jFrame.setVisible(true);
    }
}
