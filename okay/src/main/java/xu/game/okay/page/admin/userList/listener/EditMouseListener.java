package xu.game.okay.page.admin.userList.listener;

import xu.game.okay.MainClass;
import xu.game.okay.factory.BeanFactory;
import xu.game.okay.page.admin.userList.UserListControls;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;

public class EditMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        UserListControls.UserJLabel userJLabel = BeanFactory.userListJPanel.userListControls.userJLabels
                .stream().filter(userL -> userL.getEdit().equals(source)).collect(Collectors.toList()).get(0);

        MainClass.jPanel = BeanFactory.userEditJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
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
