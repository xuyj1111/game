package xu.game.okay.page.register.listener;

import org.apache.logging.log4j.util.Strings;
import xu.game.okay.MainClass;
import xu.game.okay.factory.BeanFactory;
import xu.game.okay.page.register.RegisterControls;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ConfirmActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

//            String string;
//            if (username.getText().equals(""))
//                JOptionPane.showMessageDialog(null, "请输入用户名");
//            else if (password.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "请输入密码");
//            } else if (password_second.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "请输入密码");
//            } else {
//                string = instance.query("select name from biao1 where name = '" + username.getText() + "';");
//                if (username.getText().equals(string))
//                    JOptionPane.showMessageDialog(null, "该用户已存在");
//                else {
//                    if (password.getText().equals(password_second.getText())) {              //返回login_panel
//                        int number = Integer.valueOf(instance.query("select count(*) from biao1 where name != 'admin'"));
//                        if (number == 18)
//                            JOptionPane.showMessageDialog(null, "用户已满，不能注册 ");
//                        else {
//                            instance.update("INSERT INTO biao1 VALUES ('" + username.getText() + "','" +
//                                    password.getText() + "',1);");
//                            Main.login();
//                        }
//                    } else
//                        JOptionPane.showMessageDialog(null, "两次密码不一致 ");
//                }
//            }
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
        Map<String, Object> query = BeanFactory.jdbc.query("SELECT COUNT(1) FROM user WHERE name = %s", userContent);
        Long count = (Long) query.get("COUNT(1)");
        if (count != 0) {
            JOptionPane.showMessageDialog(null, "该用户已存在");
            return;
        }
        if (!pwdContent.equals(pwdContent2)) {
            JOptionPane.showMessageDialog(null, "两次密码不一致");
            return;
        }
        BeanFactory.jdbc.update("INSERT INTO user (`name`, `pwd`) VALUES(%s, %s)", userContent, pwdContent);
        MainClass.jPanel = BeanFactory.loginJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
