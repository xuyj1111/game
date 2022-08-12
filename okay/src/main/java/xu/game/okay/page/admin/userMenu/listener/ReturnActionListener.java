package xu.game.okay.page.admin.userMenu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.userEditJPanel;

/**
 * @Description: 返回键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ReturnActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.setContentPane(userEditJPanel);
        jFrame.setVisible(true);
    }
}
