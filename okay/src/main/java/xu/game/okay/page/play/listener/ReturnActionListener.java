package xu.game.okay.page.play.listener;

import xu.game.okay.MainClass;
import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (BeanFactory.playJPanel.source == PlayJPanelSource.MENUJPANEL) {
            DrawBoardUtil.init();
        }
        MainClass.jPanel = BeanFactory.definedJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
