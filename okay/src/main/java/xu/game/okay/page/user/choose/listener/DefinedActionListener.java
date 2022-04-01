package xu.game.okay.page.user.choose.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefinedActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainClass.jPanel = BeanFactory.definedJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
