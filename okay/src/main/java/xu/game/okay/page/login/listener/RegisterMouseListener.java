package xu.game.okay.page.login.listener;

import xu.game.okay.page.login.LoginControls;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.registerJPanel;

/**
 * @Description: 注册键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class RegisterMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        LoginControls.userNameF.setText("");
        LoginControls.passWordF.setText("");
        LoginControls.register.setForeground(Color.gray);
        jFrame.setContentPane(registerJPanel);
        jFrame.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        LoginControls.register.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        LoginControls.register.setForeground(Color.gray);
    }
}
