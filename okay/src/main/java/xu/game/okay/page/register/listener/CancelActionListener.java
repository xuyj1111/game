package xu.game.okay.page.register.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.register.RegisterControls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 取消键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class CancelActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        RegisterControls.usernameF.setText("");
        RegisterControls.passWordF.setText("");
        RegisterControls.passWord2F.setText("");
        MainClass.jPanel = BeanFactory.loginJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
