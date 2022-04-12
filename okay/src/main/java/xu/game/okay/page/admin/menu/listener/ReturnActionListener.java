package xu.game.okay.page.admin.menu.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 返回键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class ReturnActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainClass.jPanel = BeanFactory.adminChooseJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
