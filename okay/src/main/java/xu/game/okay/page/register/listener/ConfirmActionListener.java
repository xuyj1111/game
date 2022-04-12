package xu.game.okay.page.register.listener;

import org.apache.logging.log4j.util.Strings;
import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.register.RegisterControls;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * @Description: 确定键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ConfirmActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String userContent = RegisterControls.usernameF.getText();
        String pwdContent = new String(RegisterControls.passWordF.getPassword());
        String pwdContent2 = new String(RegisterControls.passWord2F.getPassword());
        if (Strings.isBlank(userContent)) {
            JOptionPane.showMessageDialog(null, "请输入用户名");
            return;
        }
        if (Strings.isBlank(pwdContent)) {
            JOptionPane.showMessageDialog(null, "请输入密码");
            return;
        }
        if (Strings.isBlank(pwdContent2)) {
            JOptionPane.showMessageDialog(null, "请输入密码");
            return;
        }
        Map<String, Object> query = BeanFactory.jdbc.query("SELECT COUNT(1) FROM user WHERE name = '%s'", userContent);
        Long count = (Long) query.get("COUNT(1)");
        if (count != 0) {
            JOptionPane.showMessageDialog(null, "该用户已存在");
            return;
        }
        if (!pwdContent.equals(pwdContent2)) {
            JOptionPane.showMessageDialog(null, "两次密码不一致");
            return;
        }
        query = BeanFactory.jdbc.query("SELECT COUNT(1) FROM user WHERE name != 'admin'");
        count = (Long) query.get("COUNT(1)");
        if (count < 18) {
            RegisterControls.usernameF.setText("");
            RegisterControls.passWordF.setText("");
            RegisterControls.passWord2F.setText("");
            BeanFactory.jdbc.update("INSERT INTO user (`name`, `pwd`) VALUES('%s', '%s')", userContent, pwdContent);
            MainClass.jPanel = BeanFactory.loginJPanel;
            MainClass.jFrame.setContentPane(MainClass.jPanel);
            MainClass.jFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "用户已满，不可注册");
        }
    }
}
