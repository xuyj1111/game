package xu.game.okay.page.admin.userEdit.listener;

import xu.game.okay.page.admin.userEdit.UserEditControls;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.jdbc;
import static xu.game.okay.util.BeanFactory.userListJPanel;

/**
 * @Description: 确定键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ConfirmActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = UserEditControls.userNameF.getText();
        Map<String, Object> query = jdbc.query("SELECT COUNT(1) FROM user WHERE name = '%s'", userName);
        Long count = (Long) query.get("COUNT(1)");
        if (count == 0 || userName.equals(UserEditControls.recordUserName)) {
            jdbc.update("UPDATE user SET name='%s', pwd='%s', record='%s' WHERE name='%s'",
                    userName, UserEditControls.pwdF.getText(), UserEditControls.box.getSelectedItem().toString(), UserEditControls.recordUserName);
        } else {
            JOptionPane.showMessageDialog(null, "该用户已存在");
            return;
        }
        userListJPanel.addControls();
        jFrame.setContentPane(userListJPanel);
        jFrame.setVisible(true);
    }
}
