package xu.game.okay.page.login.listener;

import org.apache.logging.log4j.util.Strings;
import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.login.LoginControls;
import xu.game.okay.page.user.choose.ChooseJPanel;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String userContent = LoginControls.userNameF.getText();
        String pwdContent = new String(LoginControls.passWordF.getPassword());
        if (Strings.isBlank(userContent)) {
            JOptionPane.showMessageDialog(null, "请输入用户名");
            return;
        }
        if (Strings.isBlank(pwdContent)) {
            JOptionPane.showMessageDialog(null, "请输入密码");
            return;
        }
        Map<String, Object> query = BeanFactory.jdbc.query("SELECT COUNT(1), pwd FROM user WHERE name = '%s'", userContent);
        Long count = (Long) query.get("COUNT(1)");
        String pwd = (String) query.get("pwd");
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "不存在该用户");
            return;
        }
        if (!pwdContent.equals(pwd)) {
            JOptionPane.showMessageDialog(null, "密码错误");
            return;
        }
        //账号密码都正确
        LoginControls.userNameF.setText("");
        LoginControls.passWordF.setText("");
        if ("admin".equals(userContent)) {
            //管理员界面
            MainClass.jPanel = BeanFactory.adminChooseJPanel;
            MainClass.jFrame.setContentPane(MainClass.jPanel);
            MainClass.jFrame.setVisible(true);
        } else {
            //用户界面
            ChooseJPanel userChooseJPanel = BeanFactory.userChooseJPanel;
            userChooseJPanel.userName = userContent;
            userChooseJPanel.addControls();
            MainClass.jPanel = userChooseJPanel;
            MainClass.jFrame.setContentPane(MainClass.jPanel);
            MainClass.jFrame.setVisible(true);
        }
    }
}
