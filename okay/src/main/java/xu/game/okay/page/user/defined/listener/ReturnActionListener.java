package xu.game.okay.page.user.defined.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DrawBoardUtil.init();
        MainClass.jPanel = BeanFactory.userChooseJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
