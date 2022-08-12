package xu.game.okay.page.init.listener;

import xu.game.okay.page.init.InitControls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.initJPanel;
import static xu.game.okay.util.BeanFactory.loginJPanel;

/**
 * @Description: 鼠标点击界面触发
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class InitMouse extends MouseAdapter {
    /**
     * @Description: 点击次数
     */
    private Integer check_num = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (check_num == 0) {
            initJPanel.add(InitControls.lets);
            initJPanel.add(InitControls.start);
        } else {
            check_num = 0;
            jFrame.setContentPane(loginJPanel);
            jFrame.setVisible(true);
        }
        initJPanel.repaint();
        check_num++;
    }
}
