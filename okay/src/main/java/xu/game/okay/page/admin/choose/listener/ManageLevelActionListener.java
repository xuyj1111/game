package xu.game.okay.page.admin.choose.listener;

import xu.game.okay.MainClass;
import xu.game.okay.util.BeanFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * @Description: 管理关卡键
 * @Author: xuyujun
 * @Date: 2022/4/12 
 */ 
public class ManageLevelActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainClass.jPanel = BeanFactory.adminMenuJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
