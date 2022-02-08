package xu.game.okay.page.user.defined.listener;

import xu.game.okay.MainClass;
import xu.game.okay.factory.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainClass.jPanel = BeanFactory.userChooseJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
