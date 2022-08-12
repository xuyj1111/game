package xu.game.okay.page.register.listener;

import xu.game.okay.page.register.RegisterControls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.loginJPanel;

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
        jFrame.setContentPane(loginJPanel);
        jFrame.setVisible(true);
    }
}
