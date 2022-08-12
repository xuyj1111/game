package xu.game.okay.page.admin.choose.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.userListJPanel;

/**
 * @Description: 管理用户键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ManageUserActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        userListJPanel.addControls();
        jFrame.setContentPane(userListJPanel);
        jFrame.setVisible(true);
    }
}
