package xu.game.okay.page.admin.userEdit.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.admin.userList.UserListJPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 取消键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class CancelActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UserListJPanel userListJPanel = BeanFactory.userListJPanel;
        userListJPanel.addControls();
        MainClass.jPanel = userListJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
