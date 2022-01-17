package xu.game.okay.page.admin.choose.listener;

import xu.game.okay.MainClass;
import xu.game.okay.factory.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainClass.jPanel = BeanFactory.loginJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
