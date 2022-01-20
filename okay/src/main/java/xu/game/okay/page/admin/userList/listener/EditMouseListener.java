package xu.game.okay.page.admin.userList.listener;

import xu.game.okay.MainClass;
import xu.game.okay.entity.User;
import xu.game.okay.factory.BeanFactory;
import xu.game.okay.page.admin.userEdit.UserEditControls;
import xu.game.okay.page.admin.userList.UserListControls;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;

public class EditMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        UserListControls userListControls = BeanFactory.userListJPanel.userListControls;
        //获取触发事件的控件
        JLabel source = (JLabel) e.getSource();
        //控件设置灰色
        source.setForeground(Color.gray);
        //获取该控件对应的其他控件，即用户名
        UserListControls.UserJLabel userJLabel = userListControls.userJLabels
                .stream().filter(userL -> userL.getEdit().equals(source)).collect(Collectors.toList()).get(0);
        //获取user对象
        User user = userListControls.userList
                .stream().filter(u -> u.getName().equals(userJLabel.getUser().getText())).collect(Collectors.toList()).get(0);
        //赋值
        UserEditControls.recordUserName = user.getName();
        UserEditControls.userNameF.setText(user.getName());
        UserEditControls.pwdF.setText(user.getPwd());
        UserEditControls.box.setSelectedItem(user.getRecord());
        //切换页面
        MainClass.jPanel = BeanFactory.userEditJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
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
