package xu.game.okay.page.init.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.init.InitControls;

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
            MainClass.jPanel = BeanFactory.loginJPanel;
            MainClass.jFrame.setContentPane(MainClass.jPanel);
            MainClass.jFrame.setVisible(true);
        }
        initJPanel.repaint();
        check_num++;
    }
}
