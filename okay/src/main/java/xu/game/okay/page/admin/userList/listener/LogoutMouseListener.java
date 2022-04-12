package xu.game.okay.page.admin.userList.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.admin.userList.UserListControls;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;

/**
 * @Description: 用户注销键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class LogoutMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        //获取触发事件的控件
        Object source = e.getSource();
        //获取该控件对应的其他控件，即用户名
        UserListControls.UserJLabel userJLabel = BeanFactory.userListJPanel.userListControls.userJLabels
                .stream().filter(userL -> userL.getLogout().equals(source)).collect(Collectors.toList()).get(0);
        //弹出判断框
        int result = JOptionPane.showConfirmDialog(null, "是否删除该用户？", "删除用户", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        //点击yes后
        if (result == 0) {
            //删除对应用户名的数据，并重新刷新当前界面
            BeanFactory.jdbc.update("DELETE FROM user WHERE name = '%s'", userJLabel.user.getText());
            BeanFactory.userListJPanel.addControls();
            MainClass.jFrame.setContentPane(MainClass.jPanel);
            MainClass.jFrame.setVisible(true);
        }
    }

    /**
     * @Description: 鼠标移入控件，控件变蓝
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getSource();
        jLabel.setForeground(Color.BLUE);
    }

    /**
     * @Description: 鼠标移出控件，控件变灰
     */
    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getSource();
        jLabel.setForeground(Color.gray);
    }
}
