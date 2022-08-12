package xu.game.okay.page.login.listener;

import org.apache.logging.log4j.util.Strings;
import xu.game.okay.page.login.LoginControls;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.adminChooseJPanel;
import static xu.game.okay.util.BeanFactory.jdbc;
import static xu.game.okay.util.BeanFactory.userChooseJPanel;

/**
 * @Description: 登录键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
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
        Map<String, Object> query = jdbc.query("SELECT COUNT(1), pwd FROM user WHERE name = '%s'", userContent);
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
        // 账号密码都正确
        LoginControls.userNameF.setText("");
        LoginControls.passWordF.setText("");
        if ("admin".equals(userContent)) {
            // 管理员界面
            jFrame.setContentPane(adminChooseJPanel);
            jFrame.setVisible(true);
        } else {
            // 用户界面
            userChooseJPanel.userName = userContent;
            userChooseJPanel.addControls();
            jFrame.setContentPane(userChooseJPanel);
            jFrame.setVisible(true);
        }
    }
}
