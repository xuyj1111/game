package xu.game.okay.page.login.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.login.LoginControls;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        LoginControls.userNameF.setText("");
        LoginControls.passWordF.setText("");
        LoginControls.register.setForeground(Color.gray);
        MainClass.jPanel = BeanFactory.registerJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
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
