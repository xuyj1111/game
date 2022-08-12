package xu.game.okay.page.play.listener;

import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.definedJPanel;
import static xu.game.okay.util.BeanFactory.playJPanel;

public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (playJPanel.source == PlayJPanelSource.MENUJPANEL) {
            DrawBoardUtil.init();
        }
        jFrame.setContentPane(definedJPanel);
        jFrame.setVisible(true);
    }
}
