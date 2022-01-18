package xu.game.okay.page.admin.userList.listener;

import xu.game.okay.MainClass;
import xu.game.okay.factory.BeanFactory;
import xu.game.okay.page.admin.userList.UserListControls;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;

public class LogoutMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        UserListControls.UserJLabel userJLabel = BeanFactory.userListJPanel.userListControls.userJLabels
                .stream().filter(userL -> userL.getLogout().equals(source)).collect(Collectors.toList()).get(0);
        int result = JOptionPane.showConfirmDialog(null, "是否删除该用户？", "删除用户", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == 0) {
            BeanFactory.jdbc.update("DELETE FROM user WHERE name = '%s'", userJLabel.user.getText());
            BeanFactory.userListJPanel.addControls();
            MainClass.jFrame.setContentPane(MainClass.jPanel);
            MainClass.jFrame.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getSource();
        jLabel.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getSource();
        jLabel.setForeground(Color.gray);
    }
}
