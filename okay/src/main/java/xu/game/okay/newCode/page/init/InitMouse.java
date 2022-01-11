package xu.game.okay.newCode.page.init;

import xu.game.okay.newCode.TestMain;
import xu.game.okay.newCode.factory.BeanFactory;
import xu.game.okay.newCode.page.base.BaseJPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitMouse extends MouseAdapter {
    /**
     * @Description: 点击次数
     */
    private Integer check_num = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        BaseJPanel initJPanel = BeanFactory.initJPanel;
        if (check_num == 0) {
            initJPanel.add(InitControls.lets);
            initJPanel.add(InitControls.start);
        } else {
            check_num = 0;
            TestMain.jPanel = BeanFactory.loginJPanel;
            TestMain.jFrame.setContentPane(TestMain.jPanel);
            TestMain.jFrame.setVisible(true);
        }
        initJPanel.repaint();
        check_num++;
    }
}
