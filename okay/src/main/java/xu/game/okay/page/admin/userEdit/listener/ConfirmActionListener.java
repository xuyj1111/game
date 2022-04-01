package xu.game.okay.page.admin.userEdit.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.admin.userEdit.UserEditControls;
import xu.game.okay.page.admin.userList.UserListJPanel;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ConfirmActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = UserEditControls.userNameF.getText();
        Map<String, Object> query = BeanFactory.jdbc.query("SELECT COUNT(1) FROM user WHERE name = '%s'", userName);
        Long count = (Long) query.get("COUNT(1)");
        if (count == 0 || userName.equals(UserEditControls.recordUserName)) {
            BeanFactory.jdbc.update("UPDATE user SET name='%s', pwd='%s', record='%s' WHERE name='%s'",
                    userName, UserEditControls.pwdF.getText(), UserEditControls.box.getSelectedItem().toString(), UserEditControls.recordUserName);
        } else {
            JOptionPane.showMessageDialog(null, "该用户已存在");
            return;
        }
        UserListJPanel userListJPanel = BeanFactory.userListJPanel;
        userListJPanel.addControls();
        MainClass.jPanel = userListJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
